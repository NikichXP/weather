package com.nikichxp.weather.service

import com.nikichxp.weather.TelegramSender
import com.nikichxp.weather.model.Subscription
import org.bson.Document
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class SubscriptionService(
		private val weatherImgService: WeatherImgService,
		private val telegramSender: TelegramSender,
		private val mongoTemplate: MongoTemplate) {

	@PostConstruct
	fun performBroadcasts() {
		getSubscriptionStationList().forEach { weatherImgService.initializeStationWorker(it) }
	}

	fun subscribe(userId: String, station: String) {
		mongoTemplate.save(
				Subscription(
						userId = userId,
						station = station
				)
		)
		weatherImgService.initializeStationWorker(station)
	}

	private fun getSubscriptionStationList(): List<String> = mongoTemplate.aggregate(
			Aggregation.newAggregation(
					Subscription::class.java,
					Aggregation.group("\$station")
			),
			Subscription::class.java, Document::class.java)
			.mappedResults
			.map { it["_id"] as String }

	fun broadcastNewResult(station: WeatherImgService.StationInfo) {
		val userList = mongoTemplate.find<Subscription>(Query.query(Criteria.where("station").`is`(station.id)))
				.map { it.userId }.distinct()
		for (user in userList) {
			telegramSender.sendMessage(user, station.url)
		}
	}
}
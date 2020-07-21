package com.nikichxp.weather.service

import com.nikichxp.weather.model.Subscription
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class SubscriptionService(
        private val mongoTemplate: MongoTemplate) {

    fun subscribe(userId: String, station: String) {
        mongoTemplate.save(
                Subscription(
                        userId = userId,
                        station = station
                )
        )
    }

}
package com.nikichxp.weather.service

import com.nikichxp.weather.provider.WeatherImgProvider
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.annotation.Lazy
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

@Service
class WeatherImgService(
		private val weatherImgProvider: WeatherImgProvider,
		@Lazy private val subscriptionService: SubscriptionService
) {

	private val pool = Executors.newScheduledThreadPool(1)
	private val cache = mutableSetOf<StationInfo>()

	fun initializeStationWorker(station: String) {
		cache.find { it.id == station } ?: fetchNewStation(station)
	}

	private fun fetchNewStation(stationId: String) {
		StationInfo(stationId).apply {
			url = weatherImgProvider.getPhotoUrl(id)
			content = weatherImgProvider.getPhotoContent(url)
			lastUpdated = LocalDateTime.now()
			pool.schedule({ scout(this) }, 10, TimeUnit.MINUTES)
		}
	}

	private fun scout(station: StationInfo) {
		val url = weatherImgProvider.getPhotoUrl(station.id)
		if (station.url != url) {
			station.content = weatherImgProvider.getPhotoContent(url)
			pool.schedule({ scout(station) }, 10, TimeUnit.MINUTES)
			subscriptionService.broadcastNewResult(station)
		} else {
			pool.schedule({ scout(station) }, 1, TimeUnit.MINUTES)
		}
	}

	data class StationInfo(val id: String) {
		var url = ""
		var content = byteArrayOf()
		var lastUpdated = LocalDateTime.now().minusYears(1)
	}

}
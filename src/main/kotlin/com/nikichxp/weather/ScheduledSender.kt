package com.nikichxp.weather

import com.nikichxp.weather.provider.WeatherImgProvider
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledSender(
		private val telegramSender: TelegramSender,
		private val provider: WeatherImgProvider
) {

	private val nikichXPId = "34080460"

	@Scheduled(fixedDelay = 1_000 * 60)
	fun sendMeSomeInfo() {
		telegramSender.sendMessage(nikichXPId, provider.getPhotoUrl())
	}

}
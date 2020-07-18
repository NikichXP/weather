package com.nikichxp.weather.api

import com.nikichxp.weather.TelegramSender
import com.nikichxp.weather.provider.WeatherImgProvider
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestAPI(
		private val weatherImgProvider: WeatherImgProvider,
		private val telegramSender: TelegramSender
) {

	@GetMapping("/weather")
	fun test(): String {
		return weatherImgProvider.getPhotoUrl()
	}

	@GetMapping("/send")
	fun send(@RequestParam to: String): String {
		telegramSender.sendMessage(to, weatherImgProvider.getPhotoUrl())
		return "ok"
	}

}
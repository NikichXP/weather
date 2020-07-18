package com.nikichxp.weather

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class TelegramSender(
		private val restTemplate: RestTemplate
) {

	private val botId = "1390933695:AAHXa0-29rEKuPoNeCOA7Jx6mfYBKN-QzWo"
	private val botAPI = "https://api.telegram.org/bot$botId"



	fun sendMessage(to: String, text: String) {
		val request = "$botAPI/sendMessage?chat_id=$to&text=$text"
		restTemplate.getForObject<Any>(request)
	}

}
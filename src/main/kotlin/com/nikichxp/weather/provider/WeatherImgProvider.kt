package com.nikichxp.weather.provider

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.time.LocalDateTime
import java.util.logging.Logger
import java.util.regex.Pattern
import javax.annotation.PostConstruct

@Service
class WeatherImgProvider(
		private val restTemplate: RestTemplate
) {

	private val responseMap = mutableMapOf<String, ResponseStatus>()
	var response = ""

	fun getPhotoUrl(station: String = "UKBB"): String {
		return "http://meteoinfo.by/radar/$station/${getPhotoName(station)}"
	}

	fun getPhotoName(station: String): String {
		response = restTemplate.getForObject("http://meteoinfo.by/radar/?q=$station")
		val pattern = Pattern.compile(station + "_\\d*[.]png")
		val matcher = pattern.matcher(response)
		matcher.find()
		return matcher.group()
	}

	/**
	 * Gets photo content;
	 * TODO if possible, get input stream and write it to the TG API
	 */
	fun getPhotoContent(url: String): ByteArray {
		return restTemplate.getForObject(url)
	}

	/*
	TODO Хранить результат в виде картинки как результат работы, а не как сейчас - хранится весь ответ
	 */

	private fun getResponse(station: String): String {
		val data = responseMap.getOrPut(station) { ResponseStatus(restTemplate.getForObject("http://meteoinfo.by/radar/?q=UKBB")) }
		if (LocalDateTime.now().isAfter(data.timeout)) {
			val newResponse = restTemplate.getForObject<String>("http://meteoinfo.by/radar/?q=UKBB")
			if (data.response == newResponse) {
				data.timeout = data.timeout.plusMinutes(1)
			} else {
				data.timeout = data.timeout.plusMinutes(10)
				data.response = newResponse
			}
		}
		return data.response
	}

	data class ResponseStatus(
			var response: String,
			var responseTime: Long = System.currentTimeMillis(),
			var timeout: LocalDateTime = LocalDateTime.now().plusMinutes(1)
	)
}
package com.nikichxp.weather.service

import com.nikichxp.weather.provider.WeatherImgProvider
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

@Service
class WeatherImgService(
        private val weatherImgProvider: WeatherImgProvider
) {

    private val pool = Executors.newScheduledThreadPool(1)
    private var knownPhotos = LinkedList<String>()
    private var content = ByteArray(0)

    @PostConstruct
    fun init() {
        pool.schedule(this::scout, 1, TimeUnit.SECONDS)
    }

    fun scout() {
        val url = weatherImgProvider.getPhotoUrl()
        if (!knownPhotos.contains(url)) {
            content = weatherImgProvider.getPhotoContent()
            pool.schedule(this::scout, 10, TimeUnit.MINUTES)
            // broadcast the result
        } else {
            pool.schedule(this::scout, 1, TimeUnit.MINUTES)
        }
    }

}
package com.nikichxp.weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class WeatherApplication

fun main() {
    runApplication<WeatherApplication>()
}

package com.nikichxp.weather.model

import org.springframework.data.mongodb.core.index.Indexed

data class Subscription(
        var userId: String,
        @Indexed var station: String
) {
    var id = "$station-$userId"
}
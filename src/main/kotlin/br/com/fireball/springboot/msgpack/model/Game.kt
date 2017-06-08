package br.com.fireball.springboot.msgpack.model

import java.util.*

/**
 * Created by carlos on 08/06/17.
 */
data class Game(
        val id: Int,
        val title: String,
        val releaseDate: Date,
        val fireballRating: Double
)
package br.com.fireball.springboot.msgpack.repository

import br.com.fireball.springboot.msgpack.model.Game

/**
 * Created by carlos on 08/06/17.
 */
class GameRepository(val games: List<Game>) {

    fun findAll() = games

    fun findById(id: Int) = games.firstOrNull { it.id == id }

}
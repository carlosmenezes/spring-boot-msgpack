package br.com.fireball.springboot.msgpack.controller

import br.com.fireball.springboot.msgpack.model.Game
import br.com.fireball.springboot.msgpack.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

/**
 * Created by carlos on 08/06/17.
 */
@RestController
class GamesController {

    @Autowired
    lateinit var repository: GameRepository

    val logger = Logger.getLogger(GamesController::class.java.name)

    @RequestMapping(value = "/games/{id}", produces = arrayOf("application/x-msgpack", "application/json"))
    fun findById(@PathVariable("id") id: Int) : Game? {

        logger.info("Game.findById($id)")
        return repository.findById(id)
    }

    @RequestMapping(value = "/games", produces = arrayOf("application/x-msgpack", "application/json"))
    fun findAll() : List<Game> {
        logger.info("Game.findAll()")
        return repository.findAll()
    }

}
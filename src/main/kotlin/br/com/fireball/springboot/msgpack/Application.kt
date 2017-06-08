package br.com.fireball.springboot.msgpack

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by carlos on 08/06/17.
 */

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    run(Application::class.java, *args)
}
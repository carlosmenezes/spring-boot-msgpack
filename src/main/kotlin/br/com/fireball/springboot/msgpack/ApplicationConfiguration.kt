package br.com.fireball.springboot.msgpack

import br.com.fireball.springboot.msgpack.model.Game
import br.com.fireball.springboot.msgpack.repository.GameRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.msgpack.jackson.dataformat.MessagePackFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.MediaType
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.time.LocalDate.parse
import java.time.ZoneId.systemDefault
import java.util.*

/**
 * Created by carlos on 08/06/17.
 */

@Configuration
open class ApplicationConfiguration {

    @Bean
    @Primary
    open fun msgpackHttpMessageConverter() =
           object: AbstractJackson2HttpMessageConverter(
                   ObjectMapper(MessagePackFactory()), MediaType("application", "x-msgpack")) {
           }

    @Bean
    open fun restTemplate(messageConverter: AbstractJackson2HttpMessageConverter) = RestTemplate(listOf(msgpackHttpMessageConverter()))

    @Bean
    open fun gameRepository(): GameRepository {
        val games = listOf(
                Game(id = 1, title = "Witcher 3: Wild Hunt", releaseDate = newDate("2015-05-19"), fireballRating = 10.0),
                Game(id = 2, title = "Project Cars", releaseDate = newDate("2015-05-06"), fireballRating = 10.0),
                Game(id = 3, title = "The Elder Scrolls V: Skyrim", releaseDate = newDate("2011-11-11"), fireballRating = 9.5),
                Game(id = 4, title = "Mass Effect 3", releaseDate = newDate("2012-03-06"), fireballRating = 8.5),
                Game(id = 5, title = "Formula 1 2016", releaseDate = newDate("2016-08-19"), fireballRating = 9.0),
                Game(id = 6, title = "Fallout 3", releaseDate = newDate("2008-10-28"), fireballRating = 8.0),
                Game(id = 7, title = "Fallout New Vegas", releaseDate = newDate("2010-10-19"), fireballRating = 9.5),
                Game(id = 8, title = "Battlefield 4", releaseDate = newDate("2013-10-29"), fireballRating = 10.0),
                Game(id = 9, title = "Left 4 Dead 2", releaseDate = newDate("2009-11-17"), fireballRating = 10.0)
        )

        return GameRepository(games)
    }

    private fun newDate(dateString: String) = Date.from(parse(dateString).atStartOfDay(systemDefault()).toInstant())

}
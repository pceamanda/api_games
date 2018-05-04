package com.fiap.amanda.gamesapi.resource

import com.fiap.amanda.gamesapi.entity.Game
import com.fiap.amanda.gamesapi.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/game")
class GameResource {

    @Autowired
    lateinit var gameService: GameService

    @GetMapping
    fun findAll() : List<Game>{
        return gameService.findAll()
    }

    @GetMapping("/{category}")
    fun findByGategory(@PathVariable("category") category: String) : List<Game>{
        return gameService.findByCategory(category)
    }

    @PutMapping
    fun update(@RequestBody game:Game) {
        gameService.save(game)
    }

    @PostMapping
    fun create(@RequestBody game:Game) {
        gameService.save(game)
    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathParam("id") id: Long) {
        gameService.delete(id)
    }

}
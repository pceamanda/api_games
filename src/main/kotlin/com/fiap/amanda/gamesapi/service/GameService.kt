package com.fiap.amanda.gamesapi.service

import com.fiap.amanda.gamesapi.entity.Game
import com.fiap.amanda.gamesapi.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameService {

    @Autowired
    lateinit var gameRepository: GameRepository

    @Autowired
    lateinit var nextSequenceService: NextSequenceService

    fun findAll(): List<Game> {
        return gameRepository.findAll()
    }

    fun findByCategory(category: String): List<Game> {
        return gameRepository.findByCategoryContaining(category)
    }

    fun save(game: Game) {
        if(game.id == null) {
            game.id = nextSequenceService.getNextSequence("customSequences")
        }
        gameRepository.save(game)
    }

    fun delete(id: Long) {
        gameRepository.deleteById(id)
    }

}
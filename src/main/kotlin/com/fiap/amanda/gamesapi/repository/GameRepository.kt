package com.fiap.amanda.gamesapi.repository

import com.fiap.amanda.gamesapi.entity.Game
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : MongoRepository<Game, Long> {

    fun findByCategoryContaining(category: String) : List<Game>

}
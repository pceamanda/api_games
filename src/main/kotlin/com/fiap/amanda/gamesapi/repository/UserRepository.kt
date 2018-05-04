package com.fiap.amanda.gamesapi.repository

import com.fiap.amanda.gamesapi.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, Long> {

    fun findByUsernameAndPassword(username: String, password: String) : User

    fun findByUsername(username: String) : User?

}
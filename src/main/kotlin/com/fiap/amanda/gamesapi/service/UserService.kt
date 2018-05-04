package com.fiap.amanda.gamesapi.service

import com.fiap.amanda.gamesapi.entity.User
import com.fiap.amanda.gamesapi.repository.UserRepository
import javassist.tools.web.BadHttpRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var nextSequenceService: NextSequenceService

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun findByUsernameAndPassword(username: String, password: String): User {
        return userRepository.findByUsernameAndPassword(username, password)
    }

    fun save(user: User) {

        userRepository.findByUsername(user.username) ?: throw BadHttpRequest()

        if(user.id == null) {
            user.id = nextSequenceService.getNextSequence("customSequences")
        }

        userRepository.save(user)
    }

}
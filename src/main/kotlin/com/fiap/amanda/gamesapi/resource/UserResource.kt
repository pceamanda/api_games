package com.fiap.amanda.gamesapi.resource

import com.fiap.amanda.gamesapi.entity.User
import com.fiap.amanda.gamesapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserResource {

    @Autowired
    lateinit var userService: UserService

    @PostMapping(path = ["/login"])
    fun login(@RequestBody user: User) : User{
        return userService.findByUsernameAndPassword(user.username, user.password)
    }

    @PostMapping
    fun create(@RequestBody user : User) {
        userService.save(user)
    }

}
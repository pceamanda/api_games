package com.fiap.amanda.gamesapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(@Id var id: Long?,
                var username: String,
                var password: String)
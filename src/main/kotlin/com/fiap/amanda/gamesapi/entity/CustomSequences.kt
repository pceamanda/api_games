package com.fiap.amanda.gamesapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customSequences")
class CustomSequences {

    @Id
    val id: String? = null
    val seq: Long = 0

}
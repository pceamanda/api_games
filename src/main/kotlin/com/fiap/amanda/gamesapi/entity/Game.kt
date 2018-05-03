package com.fiap.amanda.gamesapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Game(@Id var id: Long?,
                var title: String,
                var platform: String,
                var category: String,
                var imageUrl: String)
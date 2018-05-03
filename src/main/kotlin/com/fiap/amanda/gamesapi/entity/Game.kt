package com.fiap.amanda.gamesapi.entity

data class Game( var id: Long?,
                 var title: String,
                 var platform: String,
                 var category: String,
                 var imageUrl: String)
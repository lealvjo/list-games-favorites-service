package com.games.demo.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class GamesForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 100, message = "Game min 5 and max 100 characters")
    val game: String,
    @field:NotEmpty
    val platform: String,
    @field:NotNull
    val hasGame: Boolean,
    @field:NotNull
    val idUser: Long
)


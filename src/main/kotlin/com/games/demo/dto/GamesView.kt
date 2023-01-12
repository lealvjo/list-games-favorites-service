package com.games.demo.dto

import com.games.demo.model.DlcEnum
import com.games.demo.model.User
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class GamesView(
    val id: Long?,
    val game: String,
    val platform: String,
    val hasGame: Boolean,
    val user: User,
    var started: Boolean?,
    var finished: Boolean?,
    @Enumerated(value = EnumType.STRING)
    var dlc: DlcEnum?
)
package com.games.demo.repository

import com.games.demo.model.Games
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Games, Long> {

    fun findByGame(gameName: String, pageable: Pageable): Page<Games>

}
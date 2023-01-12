package com.games.demo.controller

import com.games.demo.dto.GamesForm
import com.games.demo.dto.GamesView
import com.games.demo.dto.UpdateGameForm
import com.games.demo.service.ServiceGame
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/games")
class GameController(private val serviceGame: ServiceGame) {

    @GetMapping
    fun listGames(
        @RequestParam(required = false) nameGame: String?,
        @PageableDefault(size = 5, sort = ["game"]) pagination: Pageable
    ): Page<GamesView> {
        return serviceGame.list(nameGame, pagination)
    }

    @GetMapping("/{id}")
    @Cacheable("CacheByIdGame")
    fun getGameById(@PathVariable id: Long): GamesView {
        return serviceGame.getGameById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["CacheByIdGame"], allEntries = true)
    fun registerGame(
        @RequestBody @Valid form: GamesForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<GamesView> {
        val gameView = serviceGame.register(form)
        val uri = uriBuilder.path("/games/${gameView.id}").build().toUri()
        return ResponseEntity.created(uri).body(gameView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["CacheByIdGame"], allEntries = true)
    fun updateTopic(@RequestBody @Valid form: UpdateGameForm): ResponseEntity<GamesView> {
        val gameUpdate = serviceGame.update(form)
        return ResponseEntity.ok(gameUpdate)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = ["CacheByIdGame"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteGame(@PathVariable id: Long) {
        serviceGame.delete(id)
    }

}
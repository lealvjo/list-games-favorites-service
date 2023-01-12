package com.games.demo.service

import com.games.demo.dto.GamesForm
import com.games.demo.dto.GamesView
import com.games.demo.dto.UpdateGameForm
import com.games.demo.mapper.GameViewMapper
import com.games.demo.model.Games
import com.games.demo.repository.GameRepository
import com.games.demo.exception.NotFoundException
import com.games.demo.mapper.GameFormMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ServiceGame (
    private val repository: GameRepository,
    private val gameViewMapper: GameViewMapper,
    private val gameFormMapper: GameFormMapper,
    private val notFoundMessage: String = "Topic Not Found"
){
    fun list(nameGame: String?, pagination: Pageable): Page<GamesView> {
        val games = if(nameGame == null) {
            repository.findAll(pagination)
        } else {
            repository.findByGame(nameGame, pagination)
        }
        return games.map { t ->
            gameViewMapper.map(t)
        }
    }

    fun getGameById(id: Long): GamesView {
        val game = getById(id)
        return gameViewMapper.map(game)
    }

    fun register(form: GamesForm): GamesView {
        val game = gameFormMapper.map(form)
        repository.save(game)
        return gameViewMapper.map(game)
    }

    fun update(form: UpdateGameForm): GamesView {
        val game = getById(form.id)
        game.started = form.started
        game.finished = form.finished
        game.dlc = form.dlc
        repository.save(game)
        return gameViewMapper.map(game)
    }

    fun delete(id: Long){
        repository.deleteById(id)
    }

    fun getById(id: Long): Games {
        return repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
    }

}

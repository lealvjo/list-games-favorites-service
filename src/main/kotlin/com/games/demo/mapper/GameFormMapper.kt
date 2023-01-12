package com.games.demo.mapper

import com.games.demo.dto.GamesForm
import com.games.demo.model.Games
import com.games.demo.service.UserService
import org.springframework.stereotype.Component

@Component
class GameFormMapper(private val userService: UserService,): Mapper <GamesForm, Games> {
    override fun map(game: GamesForm): Games {
        return Games(
            game = game.game,
            platform = game.platform,
            hasGame = game.hasGame,
            user = userService.findUserById(game.idUser)
        )
    }
}

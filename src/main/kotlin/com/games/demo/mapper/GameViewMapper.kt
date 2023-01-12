package com.games.demo.mapper

import com.games.demo.dto.GamesView
import com.games.demo.model.Games
import org.springframework.stereotype.Component

@Component
class GameViewMapper: Mapper <Games,GamesView> {
    override fun map(game: Games): GamesView {
        return GamesView(
            id = game.id,
            game = game.game,
            platform = game.platform,
            hasGame = game.hasGame,
            user = game.user,
            started = game.started,
            finished = game.finished,
            dlc = game.dlc
        )
    }
}
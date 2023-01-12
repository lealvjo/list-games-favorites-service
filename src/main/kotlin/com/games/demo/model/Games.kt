package com.games.demo.model

import javax.persistence.*

@Entity
data class Games(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val game: String,
    val platform: String,
    val hasGame: Boolean,
    var started: Boolean? = null,
    var finished: Boolean? = null,
    @Enumerated(value = EnumType.STRING)
    var dlc: DlcEnum? = DlcEnum.DOES_NOT_HAVE,
    @ManyToOne
    val user: User
)
package com.games.demo.dto

import com.games.demo.model.DlcEnum
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class UpdateGameForm(
    val id: Long,
    val started: Boolean?,
    val finished: Boolean?,
    @Enumerated(value = EnumType.STRING)
    val dlc: DlcEnum?
)

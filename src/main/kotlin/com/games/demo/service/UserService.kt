package com.games.demo.service

import com.games.demo.model.User
import com.games.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun findUserById(id: Long): User {
        return repository.getOne(id)
    }

}
package com.games.demo.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}

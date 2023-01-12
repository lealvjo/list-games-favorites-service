package com.games.demo.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message)
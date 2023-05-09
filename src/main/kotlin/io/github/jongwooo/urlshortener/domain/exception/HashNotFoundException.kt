package io.github.jongwooo.urlshortener.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class HashNotFoundException(hash: String) : RuntimeException("$hash not found")

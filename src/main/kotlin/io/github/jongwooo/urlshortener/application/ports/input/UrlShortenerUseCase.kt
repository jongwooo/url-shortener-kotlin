package io.github.jongwooo.urlshortener.application.ports.input

interface UrlShortenerUseCase {

  fun shorten(url: String): String

  fun resolve(hash: String): String
}

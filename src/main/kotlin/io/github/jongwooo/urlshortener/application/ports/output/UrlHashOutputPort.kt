package io.github.jongwooo.urlshortener.application.ports.output

interface UrlHashOutputPort {

  fun saveUrlByHash(key: String, value: String)

  fun getUrlByHash(key: String): String?
}

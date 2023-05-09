package io.github.jongwooo.urlshortener.infrastructure.adapters.output.persistence

import io.github.jongwooo.urlshortener.application.ports.output.UrlHashOutputPort
import io.github.jongwooo.urlshortener.infrastructure.adapters.output.persistence.repository.UrlHashRepository

class UrlHashPersistenceAdapter(private val urlHashRepository: UrlHashRepository) : UrlHashOutputPort {

  override fun saveUrlByHash(key: String, value: String) {
    urlHashRepository.set(key, value)
  }

  override fun getUrlByHash(key: String): String? {
    return urlHashRepository.get(key)
  }
}

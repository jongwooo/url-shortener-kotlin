package io.github.jongwooo.urlshortener.domain.service

import io.github.jongwooo.urlshortener.application.ports.input.UrlShortenerUseCase
import io.github.jongwooo.urlshortener.application.ports.output.UrlHashOutputPort
import io.github.jongwooo.urlshortener.domain.exception.HashNotFoundException
import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class UrlShortenerService(private val urlHashOutputPort: UrlHashOutputPort) : UrlShortenerUseCase {

  private val digest = MessageDigest.getInstance("SHA-256")

  private fun hash(url: String, length: Int = 6): String {
    val bytes = digest.digest(url.toByteArray())
    val hashString = String.format("%32x", java.math.BigInteger(1, bytes))

    return hashString.take(length)
  }

  override fun shorten(url: String): String {
    val hash = hash(url)
    urlHashOutputPort.saveUrlByHash(hash, url)

    return hash
  }

  override fun resolve(hash: String): String {
    return urlHashOutputPort.getUrlByHash(hash) ?: throw HashNotFoundException(hash)
  }
}

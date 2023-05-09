package io.github.jongwooo.urlshortener.infrastructure.adapters.input.rest

import io.github.jongwooo.urlshortener.application.ports.input.UrlShortenerUseCase
import io.github.jongwooo.urlshortener.infrastructure.adapters.input.rest.data.request.UrlShortenerRequest
import io.github.jongwooo.urlshortener.infrastructure.adapters.input.rest.data.response.UrlShortenerResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class UrlShortenerRestAdapter(private val urlShortenerUseCase: UrlShortenerUseCase) {

  @PostMapping("/")
  fun shorten(@RequestBody request: UrlShortenerRequest): UrlShortenerResponse {
    val hash = urlShortenerUseCase.shorten(request.url)
    return UrlShortenerResponse(hash)
  }

  @GetMapping("/{hash}")
  fun resolve(@PathVariable hash: String): ResponseEntity<HttpStatus> {
    val target = urlShortenerUseCase.resolve(hash)

    return ResponseEntity
      .status(HttpStatus.MOVED_PERMANENTLY)
      .location(URI.create(target))
      .header(HttpHeaders.CONNECTION, "close")
      .build()
  }
}

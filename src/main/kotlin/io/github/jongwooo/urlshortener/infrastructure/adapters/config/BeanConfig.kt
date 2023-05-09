package io.github.jongwooo.urlshortener.infrastructure.adapters.config

import io.github.jongwooo.urlshortener.infrastructure.adapters.output.persistence.UrlHashPersistenceAdapter
import io.github.jongwooo.urlshortener.infrastructure.adapters.output.persistence.repository.UrlHashRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

  @Bean
  fun urlHashPersistenceAdapter(urlHashRepository: UrlHashRepository): UrlHashPersistenceAdapter {
    return UrlHashPersistenceAdapter(urlHashRepository)
  }
}

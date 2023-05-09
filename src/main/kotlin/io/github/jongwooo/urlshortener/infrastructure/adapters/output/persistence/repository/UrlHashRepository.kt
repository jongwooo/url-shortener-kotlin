package io.github.jongwooo.urlshortener.infrastructure.adapters.output.persistence.repository

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class UrlHashRepository(private val redisTemplate: RedisTemplate<String, String>) {

  fun set(key: String, value: String) {
    redisTemplate.opsForValue().set(key, value)
  }

  fun get(key: String): String? {
    return redisTemplate.opsForValue().get(key)
  }
}

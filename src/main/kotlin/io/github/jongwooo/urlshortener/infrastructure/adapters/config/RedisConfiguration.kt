package io.github.jongwooo.urlshortener.infrastructure.adapters.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@Configuration
class RedisConfiguration {

  @Value("\${spring.data.redis.host}")
  private lateinit var host: String

  @Value("\${spring.data.redis.port}")
  private var port: Int = 6379

  @Bean
  fun redisConnectionFactory(): RedisConnectionFactory {
    return LettuceConnectionFactory(host, port)
  }
}

# URL Shortener API with Kotlin

This is a URL Shortener API written in Kotlin with the only purpose to create shortened urls, which are stored in a Redis.
The shortened links can then be used to provide a simpler access to complicated URLs.

## Structure

The project is structured in **Hexagonal Architecture**. The core of the application is the domain layer, which is
surrounded by the application layer. The application layer is surrounded by the adapter layer, which contains the
REST Controller and the Redis Database.

```
├── UrlShortenerApplication.kt
├── application
│   └── ports
│       ├── input
│       │   └── UrlShortenerUseCase.kt
│       └── output
│           └── UrlHashOutputPort.kt
├── domain
│   ├── exception
│   │   └── HashNotFoundException.kt
│   └── service
│       └── UrlShortenerService.kt
└── infrastructure
    └── adapters
        ├── config
        │   ├── BeanConfig.kt
        │   └── RedisConfig.kt
        ├── input
        │   └── rest
        │       ├── UrlShortenerRestAdapter.kt
        │       └── data
        │           ├── request
        │           │   └── UrlShortenerRequest.kt
        │           └── response
        │               └── UrlShortenerResponse.kt
        └── output
            └── persistence
                ├── UrlHashPersistenceAdapter.kt
                └── repository
                    └── UrlHashRepository.kt
```

## Installation

You need a JDK and Gradle for this project.

As a requirement a Redis is necessary. Just start a Redis container with Docker Compose:

```bash
docker-compose up -d
```

Then start the application:

```bash
./gradlew bootRun
```

## License

Licensed under the [MIT License](LICENSE).

# Reactive Spring / Spring WebFlux Multi-Module Project
> The boilerplate is built using Gradle.

You can also fork the project from Github and open it in your IDE or other editor.


## Installing / Getting started

Just run ReactiveApiApplication

## Build

You will build a RESTful web service with Spring Webflux and a WebClient consumer of that service. You will be able to see output in both System.out and at:

```
http://localhost:8081/api/v1/users/1
```

**On Docker**

```
docker build --build-arg JAR_FILE=reactive-api/build/libs/\*.jar -t springio/gs-spring-boot-docker .
```

Manage the entire build for a complex maven project in a single command, ```docker-compose up.```

```docker-compose up``` to build image and start container. Building the image automatically runs tests.


## Features

* Multi module with gradle
* Spring WebFlux
* Seperated Domain Layer

## Configuration

There is no any config to run.

## Contributing

If you'd like to contribute, please contact to me: https://twitter.com/arifacar

## Links

- Developer homepage: https://www.arifacar.com
- Related projects:
    - Todo List Backend API Service: https://github.com/arifacar/todo


## Licensing

This project is licensed under Unlicense license. This license does not require you to take the license with you to your project.
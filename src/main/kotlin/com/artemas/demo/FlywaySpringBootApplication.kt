package com.artemas.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlywaySpringBootApplication

fun main(args: Array<String>) {
    args.forEach { println("ARGUMENTS: $it") }
    runApplication<FlywaySpringBootApplication>(*args)
}

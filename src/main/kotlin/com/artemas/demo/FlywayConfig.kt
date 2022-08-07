package com.artemas.demo

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlywayConfig {
    @Bean
    @ConditionalOnProperty(value = ["migrate"], havingValue = "true", matchIfMissing = false)
    fun migrateStrategy(): FlywayMigrationStrategy {
        return FlywayMigrationStrategy {
            it.info().infoResult.migrations.forEach { println("MIGRATING: ${it.version}: ${it.description}") }
            it.migrate()
        }
    }

    @Bean
    @ConditionalOnProperty(value = ["clean"], havingValue = "true", matchIfMissing = false)
    fun cleanAndMigrateStrategy(): FlywayMigrationStrategy {
        return FlywayMigrationStrategy {
            it.info().infoResult.migrations.forEach { println("CLEANING AND MIGRATING: ${it.version}: ${it.description}") }
            it.clean()
            it.migrate()
        }
    }
}

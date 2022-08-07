package com.artemas.demo.migrations

import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.springframework.stereotype.Component

@Component
class V1__CreatePersonsTable: BaseJavaMigration() {
    override fun migrate(context: Context?) {
        context?.connection?.createStatement()?.execute("""
            CREATE TABLE persons
            (
                id      BIGINT NOT NULL,
                name    VARCHAR(255),
                surname VARCHAR(255),
                CONSTRAINT pk_persons PRIMARY KEY (id)
            );
        """.trimIndent())
    }
}

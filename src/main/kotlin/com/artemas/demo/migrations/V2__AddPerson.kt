package com.artemas.demo.migrations

import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.springframework.stereotype.Component

@Component
class V2__AddPerson: BaseJavaMigration() {
    override fun migrate(context: Context?) {
        context?.connection?.createStatement()?.execute("""
            INSERT INTO persons
            VALUES (1, 'Artemas', 'Muza');
        """.trimIndent())
    }
}

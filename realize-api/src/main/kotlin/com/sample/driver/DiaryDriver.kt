package com.sample.driver

import org.jetbrains.exposed.sql.transactions.transaction
import javax.enterprise.context.ApplicationScoped
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

@ApplicationScoped
class DiaryDriver() {
    fun findById(diaryId: Int): DiaryJson {
        Database.connect("jdbc:mysql://127.0.0.1:3306/realize", "com.mysql.cj.jdbc.Driver", "root", "password")
        var diaryJson: DiaryJson? = null
        transaction {
            diariesTable.select { diariesTable.id eq diaryId }.singleOrNull()?.let { row ->
                diaryJson = DiaryJson(
                    id = row[diariesTable.id].toString(),
                    title = row[diariesTable.title],
                    body = row[diariesTable.body],
                    author = row[diariesTable.author],
                    releaseDate = row[diariesTable.releaseDate]
                )
            }

        }

        return diaryJson!!
    }
}

data class DiaryJson(
    val id: String,
    val title: String,
    val body: String,
    val author:String,
    val releaseDate: LocalDateTime
)

object diariesTable : Table() {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 100)
    val body = varchar("body", 1000)
    val author = varchar("author", 100)
    val releaseDate: Column<LocalDateTime> = datetime("release_date")
}
package com.sample.driver

import com.sample.rest.ParamsDiary
import org.jetbrains.exposed.sql.transactions.transaction
import javax.enterprise.context.ApplicationScoped
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

@ApplicationScoped
class DiaryDriver() {
    fun getAll(): List<DiaryJson> {
        Database.connect("jdbc:mysql://127.0.0.1:3306/realize", "com.mysql.cj.jdbc.Driver", "root", "password")
        val diaryJsonList = mutableListOf<DiaryJson>()
        transaction {
            diariesTable.selectAll().forEach { row ->
                diaryJsonList.add(
                    DiaryJson(
                        id = row[diariesTable.id].toString(),
                        title = row[diariesTable.title],
                        body = row[diariesTable.body],
                        author = row[diariesTable.author],
                        releaseDate = row[diariesTable.releaseDate]
                    )
                )
            }
        }

        return diaryJsonList
    }

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

    fun updateById(diaryId: Int, paramsDiary: ParamsDiary): DiaryJson {
        Database.connect("jdbc:mysql://127.0.0.1:3306/realize", "com.mysql.cj.jdbc.Driver", "root", "password")
        var diaryJson: DiaryJson? = null
        transaction {
            var diary = diariesTable.select { diariesTable.id eq diaryId }.singleOrNull()

            var title = paramsDiary.title ?: diary!![diariesTable.title]
            var body = paramsDiary.body ?: diary!![diariesTable.body]
            var author = paramsDiary.author ?: diary!![diariesTable.author]

            diary?.let {
                diariesTable.update({ diariesTable.id eq diaryId }) {
                    it[diariesTable.title] = title
                    it[diariesTable.body] = body
                    it[diariesTable.author] = author
                }
            }

            diaryJson = DiaryJson(
                id = diaryId.toString(),
                title = title,
                body = body,
                author = author,
                releaseDate = diary!![diariesTable.releaseDate]
            )
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
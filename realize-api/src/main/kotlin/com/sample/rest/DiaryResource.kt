package com.sample.rest

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.extension.toFormattedString
import com.sample.usecase.DiaryUsecase
import org.jboss.resteasy.reactive.RestPath
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/v1/diaries")
class DiaryResource(private val usecase: DiaryUsecase) {

    @GET
    @Path("/")
    fun getAll(): Response {
        val diaries = usecase.getAll()
        return Response.ok(diaries.map { it.toDiaryJson() }).build()
    }

    @GET
    @Path("{diaryId}")
    fun getById(@RestPath diaryId: Int): Response {
        val diary = usecase.getById(DiaryId(diaryId))
        return Response.ok(diary.toDiaryJson()).build()
    }
}

fun Diary.toDiaryJson(): DiaryJson {
    return DiaryJson(
        title = this.title.value,
        body = this.body.value,
        author = this.author.value,
        releaseDate = this.releaseDate.toFormattedString()
    )
}

data class DiaryJson(
    val title: String,
    val body: String,
    val author: String,
    val releaseDate: String
)
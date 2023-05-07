package com.sample.rest

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.extension.toFormattedString
import com.sample.usecase.GetDiaryUsecase
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response
import org.jboss.resteasy.reactive.RestPath

@Path("/v1/diaries")
class DiaryResource(private val usecase: GetDiaryUsecase) {
    @GET
    @Path("{diaryId}")
    fun getDiary(@RestPath diaryId: String): Response {
        val diary = usecase.execute(DiaryId(diaryId))
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
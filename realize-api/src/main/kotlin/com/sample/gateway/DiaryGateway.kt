package com.sample.gateway

import com.sample.domain.*
import com.sample.driver.DiaryDriver
import com.sample.usecase.port.DiaryPort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiaryGateway(private val diaryDriver: DiaryDriver) : DiaryPort {
    override fun getAll(): List<Diary> {
        TODO("Not yet implemented")
    }

    override fun findById(diaryId: DiaryId): Diary {
        var diaryJson = diaryDriver.findById(diaryId.value)
        return Diary(DiaryTitle(diaryJson.title), DiaryBody(diaryJson.body), DiaryAuthor(diaryJson.author), DiaryReleaseDate(
            diaryJson.releaseDate))
    }
}
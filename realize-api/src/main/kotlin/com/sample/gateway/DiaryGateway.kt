package com.sample.gateway

import com.sample.domain.*
import com.sample.driver.DiaryDriver
import com.sample.rest.ParamsDiary
import com.sample.usecase.port.DiaryPort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiaryGateway(private val diaryDriver: DiaryDriver) : DiaryPort {
    override fun getAll(): List<Diary> {
        var diariesJson = diaryDriver.getAll()
        return diariesJson.map { Diary(DiaryId(it.id.toInt()), DiaryTitle(it.title), DiaryBody(it.body), DiaryAuthor(it.author), DiaryReleaseDate(it.releaseDate)) }
    }

    override fun findById(diaryId: DiaryId): Diary {
        var diaryJson = diaryDriver.findById(diaryId.value)
        return Diary(
            DiaryId(diaryJson.id.toInt()),DiaryTitle(diaryJson.title), DiaryBody(diaryJson.body), DiaryAuthor(diaryJson.author), DiaryReleaseDate(
            diaryJson.releaseDate))
    }
    override fun create(paramsDiary: ParamsDiary): Diary {
        val diaryJson = diaryDriver.create(paramsDiary)
        return Diary(DiaryId(diaryJson.id.toInt()),DiaryTitle(diaryJson.title), DiaryBody(diaryJson.body), DiaryAuthor(diaryJson.author), DiaryReleaseDate(
            diaryJson.releaseDate))
    }
    override fun updateById(diaryId: DiaryId, paramsDiary: ParamsDiary): Diary {
        var diaryJson = diaryDriver.updateById(diaryId.value, paramsDiary)
        return Diary(
            DiaryId(diaryJson.id.toInt()) ,DiaryTitle(diaryJson.title), DiaryBody(diaryJson.body), DiaryAuthor(diaryJson.author), DiaryReleaseDate(
            diaryJson.releaseDate))
    }

    override fun deleteById(diaryId: DiaryId): Unit {
        diaryDriver.deleteById(diaryId.value)
    }
}
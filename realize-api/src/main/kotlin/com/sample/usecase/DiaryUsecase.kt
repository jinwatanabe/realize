package com.sample.usecase

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.rest.ParamsDiary
import com.sample.usecase.port.DiaryPort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiaryUsecase(private val diaryPort: DiaryPort) {

    fun getAll(): List<Diary> {
        return diaryPort.getAll()
    }

    fun getById(diaryId: DiaryId): Diary {
        return diaryPort.findById(diaryId)
    }

    fun create(paramsDiary: ParamsDiary): Diary {
        return diaryPort.create(paramsDiary)
    }

    fun updateById(diaryId: DiaryId, paramsDiary: ParamsDiary): Diary {
        return diaryPort.updateById(diaryId, paramsDiary)
    }
}
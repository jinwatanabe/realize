package com.sample.usecase

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.rest.UpdateDiary
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

    fun updateById(diaryId: DiaryId, updateDiary: UpdateDiary): Diary {
        return diaryPort.updateById(diaryId, updateDiary)
    }
}
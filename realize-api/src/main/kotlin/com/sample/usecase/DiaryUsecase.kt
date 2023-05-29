package com.sample.usecase

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.usecase.port.DiaryPort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiaryUsecase(private val diaryPort: DiaryPort) {
    fun getById(diaryId: DiaryId): Diary {
        return diaryPort.findById(diaryId)
    }
}
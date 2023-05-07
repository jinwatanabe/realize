package com.sample.usecase

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.usecase.port.DiaryPort
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetDiaryUsecase(private val diaryPort: DiaryPort) {
    fun execute(diaryId: DiaryId): Diary {
        return diaryPort.find(diaryId)
    }
}
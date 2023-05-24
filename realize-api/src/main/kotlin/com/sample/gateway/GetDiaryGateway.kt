package com.sample.gateway

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.driver.DiaryDriver
import com.sample.usecase.port.DiaryPort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetDiaryGateway(private val diaryDriver: DiaryDriver) : DiaryPort {
    override fun find(diaryId: DiaryId): Diary {
        TODO()
    }
}
package com.sample.usecase

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.usecase.port.DiaryPort
import io.mockk.every
import io.mockk.mockk
import io.quarkiverse.test.junit.mockk.InjectMock
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
class DiaryUsecaseTest {

    @Inject
    private lateinit var target: DiaryUsecase

    @InjectMock
    private lateinit var diaryPort: DiaryPort

    @Test
    fun DiaryIdをもとにDiaryを取得できること() {
        val diaryId = mockk<DiaryId>()
        val diary = mockk<Diary>()

        every { diaryPort.findById(diaryId) } returns diary
        Assertions.assertEquals(diary, target.getById(diaryId))
    }

}
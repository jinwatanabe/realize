package com.sample.usecase

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.usecase.port.DiaryPort
import io.mockk.every
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@QuarkusTest
class GetDiaryUsecaseTest {

    @Inject
    private lateinit var target: GetDiaryUsecase

    @InjectMock
    private lateinit var diaryPort: DiaryPort

    @Test
    fun DiaryIdをもとにDiaryを取得できること() {
        val diaryId = mockk<DiaryId>()
        val diary = mockk<Diary>()

        every { diaryPort.find(diaryId) } returns diary
        Assertions.assertEquals(diary, target.execute(diaryId))
    }

}
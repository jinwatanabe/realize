package com.sample.usecase

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.rest.ParamsDiary
import com.sample.usecase.port.DiaryPort
import io.mockk.*
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
    fun 全てのDiaryを取得できること() {
        val diaries = listOf(mockk<Diary>())

        every { diaryPort.getAll() } returns diaries
        Assertions.assertEquals(diaries, target.getAll())
    }

    @Test
    fun DiaryIdをもとにDiaryを取得できること() {
        val diaryId = mockk<DiaryId>()
        val diary = mockk<Diary>()

        every { diaryPort.findById(diaryId) } returns diary
        Assertions.assertEquals(diary, target.getById(diaryId))
    }

    @Test
    fun Diaryを作成できること() {
        var paramsDiary = mockk<ParamsDiary>()
        val diary = mockk<Diary>()

        every { diaryPort.create(paramsDiary) } returns diary
        Assertions.assertEquals(diary, target.create(paramsDiary))
    }

    @Test
    fun DiaryIdをもとにDiaryを更新できること() {
        val diaryId = mockk<DiaryId>()
        var paramsDiary = mockk<ParamsDiary>()
        val diary = mockk<Diary>()

        every { diaryPort.updateById(diaryId, paramsDiary) } returns diary
        Assertions.assertEquals(diary, target.updateById(diaryId, paramsDiary))
    }

    @Test
    fun DiaryIdをもとにDiaryを削除できること() {
        val diaryPort = mockk<DiaryPort>(relaxed = true)
        val diaryId = DiaryId(1)

        every { diaryPort.deleteById(diaryId) } just runs

        val diaryUsecase = DiaryUsecase(diaryPort)
        diaryUsecase.deleteById(diaryId)

        verify { diaryPort.deleteById(diaryId) }
    }

}
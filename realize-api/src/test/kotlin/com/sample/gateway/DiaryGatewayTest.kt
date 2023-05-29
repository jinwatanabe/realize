package com.sample.gateway

import com.sample.domain.*
import com.sample.driver.DiaryDriver
import com.sample.driver.DiaryJson
import io.mockk.every
import io.quarkiverse.test.junit.mockk.InjectMock
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import java.time.LocalDateTime
import javax.inject.Inject

@QuarkusTest
class DiaryGatewayTest {

    @Inject
    private lateinit var target: DiaryGateway

    @InjectMock
    private lateinit var driver: DiaryDriver

    @Test
    fun DiaryApiから取得したJsonをDiaryのリストに変換して返す() {
        val json = listOf(DiaryJson("1", "test", "body", "author", LocalDateTime.parse("2020-02-15T21:30:50")))
        val diaries = listOf(Diary(DiaryTitle("test"), DiaryBody("body"), DiaryAuthor("author"), DiaryReleaseDate(LocalDateTime.parse("2020-02-15T21:30:50"))))

        every { driver.getAll() } returns json
        Assertions.assertEquals(target.getAll(), diaries)
    }

    @Test
    fun DiaryAPiから取得したJsonをDiaryに変換して返す() {
        var diaryId = DiaryId(1)
        val json = DiaryJson("1", "test", "body", "author", LocalDateTime.parse("2020-02-15T21:30:50"))
        val diary = Diary(DiaryTitle("test"), DiaryBody("body"), DiaryAuthor("author"), DiaryReleaseDate(LocalDateTime.parse("2020-02-15T21:30:50")))

        every { driver.findById(diaryId.value) } returns json
        Assertions.assertEquals(target.findById(diaryId), diary)
    }

}
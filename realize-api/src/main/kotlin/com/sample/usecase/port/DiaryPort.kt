package com.sample.usecase.port

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.rest.UpdateDiary

interface DiaryPort {
    fun getAll(): List<Diary>
    fun findById(diaryId: DiaryId): Diary

    fun updateById(diaryId: DiaryId, updateDiary: UpdateDiary): Diary
}
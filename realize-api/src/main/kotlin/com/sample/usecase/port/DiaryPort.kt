package com.sample.usecase.port

import com.sample.domain.Diary
import com.sample.domain.DiaryId

interface DiaryPort {
    fun getAll(): List<Diary>
    fun findById(diaryId: DiaryId): Diary
}
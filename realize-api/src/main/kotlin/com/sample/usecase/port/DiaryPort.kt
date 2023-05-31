package com.sample.usecase.port

import com.sample.domain.Diary
import com.sample.domain.DiaryId
import com.sample.rest.ParamsDiary

interface DiaryPort {
    fun getAll(): List<Diary>
    fun findById(diaryId: DiaryId): Diary
    fun create(paramsDiary: ParamsDiary): Diary
    fun updateById(diaryId: DiaryId, paramsDiary: ParamsDiary): Diary
    fun deleteById(diaryId: DiaryId): Unit
}
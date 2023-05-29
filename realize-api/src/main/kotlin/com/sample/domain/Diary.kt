package com.sample.domain

import java.time.LocalDateTime

data class Diary(val title: DiaryTitle, val body: DiaryBody, val author: DiaryAuthor, val releaseDate: DiaryReleaseDate)

data class DiaryId(val value: Int)
data class DiaryTitle(val value: String)
data class DiaryBody(val value: String)
data class DiaryAuthor(val value: String)
data class DiaryReleaseDate(val value: LocalDateTime)

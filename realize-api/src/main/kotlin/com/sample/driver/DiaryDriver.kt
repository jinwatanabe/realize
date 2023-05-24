package com.sample.driver

import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class DiaryDriver() {
    fun find(diaryId: Int): DiaryJson {
        TODO()
    }
}

data class DiaryJson(
    val id: Int,
    val title: String,
    val body: String,
    val author:String,
    val releaseDate: String
)
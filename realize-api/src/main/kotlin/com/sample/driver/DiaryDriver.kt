package com.sample.driver

import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class DiaryDriver() {
    fun findById(diaryId: String): DiaryJson {
        TODO()
    }
}

data class DiaryJson(
    val id: String,
    val title: String,
    val body: String,
    val author:String,
    val releaseDate: String
)
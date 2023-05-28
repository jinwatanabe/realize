package com.sample.extension

import com.sample.domain.DiaryReleaseDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun DiaryReleaseDate.toFormattedString(): String {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(value)
}

fun StringToLocalDateTime(dateString: String): LocalDateTime {
    val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    return LocalDateTime.parse(dateString, formatter)
}

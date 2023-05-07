package com.sample.extension

import com.sample.domain.DiaryReleaseDate
import java.time.format.DateTimeFormatter

fun DiaryReleaseDate.toFormattedString(): String {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(value)
}

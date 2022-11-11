package com.example.nycschools.model

import com.squareup.moshi.Json

data class School(
    val dbn: String,
    @Json(name = "school_name")
    val schoolName: String,
)



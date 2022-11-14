package com.example.nycschools.model

import com.squareup.moshi.Json

data class SchoolDetail(
    val dbn: String,
    @Json(name = "school_name")
    val schoolName: String,
    @Json(name = "sat_critical_reading_avg_score")
    val satReading: String,
    @Json(name = "sat_math_avg_score")
    val satMath: String,
    @Json(name = "sat_writing_avg_score")
    val satWriting: String,

)
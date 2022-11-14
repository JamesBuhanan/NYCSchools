package com.example.nycschools.model

import com.squareup.moshi.Json

data class School(
    @Json(name = "dbn")
    val dbn: String,
    @Json(name = "school_name")
    val schoolName: String,
    @Json(name ="primary_address_line_1")
    val primaryAddressLine1: String,
    @Json(name ="city")
    val city: String,
    @Json(name ="state_code")
    val state: String,

)



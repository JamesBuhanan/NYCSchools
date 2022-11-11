package com.example.nycschools.service

import com.example.nycschools.model.School
import retrofit2.http.GET

interface SchoolService {
    @GET("s3k6-pzi2.json")
    suspend fun getSchoolList(): List<School>
}
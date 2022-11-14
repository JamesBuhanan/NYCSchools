package com.example.nycschools.service

import com.example.nycschools.model.School
import com.example.nycschools.model.SchoolDetail
import retrofit2.http.GET

interface SchoolService {
    @GET("s3k6-pzi2.json")
    suspend fun getSchoolList(): List<School>
    @GET("f9bf-2cp4.json")
    suspend fun getSchoolDetails(): List<SchoolDetail>
}
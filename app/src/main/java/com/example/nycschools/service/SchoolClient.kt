package com.example.nycschools.service

import com.example.nycschools.model.School
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SchoolClient {
    private val schoolService: SchoolService

    init {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        schoolService = retrofit.create(SchoolService::class.java)
    }

    suspend fun getSchoolList(): List<School> {
        return schoolService.getSchoolList()
    }

}
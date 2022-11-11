package com.example.nycschools.service

import com.example.nycschools.model.School

class SchoolRepository(private val schoolClient: SchoolClient) {
    suspend fun getSchoolList(): List<School> {
        return schoolClient.getSchoolList()
    }
}
package com.example.nycschools.usecase

import com.example.nycschools.model.School
import com.example.nycschools.service.SchoolRepository
import javax.inject.Inject

class GetSchoolList @Inject constructor(private val schoolRepository: SchoolRepository) {
    suspend operator fun invoke(): List<School> {
        return schoolRepository.getSchoolList()
    }
}
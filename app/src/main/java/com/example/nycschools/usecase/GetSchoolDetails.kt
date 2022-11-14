package com.example.nycschools.usecase

import com.example.nycschools.model.SchoolDetail
import com.example.nycschools.service.SchoolDetailRepository
import javax.inject.Inject

interface GetSchoolDetails {
    suspend operator fun invoke(dbn: String): Result<SchoolDetail>
}

class GetSchoolDetailsImpl @Inject constructor(
    private val schoolDetailRepository: SchoolDetailRepository
) : GetSchoolDetails {
    override suspend operator fun invoke(dbn: String): Result<SchoolDetail> {
        return schoolDetailRepository.getSchoolDetail(dbn)
    }
}
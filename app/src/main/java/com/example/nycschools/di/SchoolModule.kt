package com.example.nycschools.di

import com.example.nycschools.service.SchoolDetailRepository
import com.example.nycschools.service.SchoolDetailRepositoryImpl
import com.example.nycschools.service.SchoolService
import com.example.nycschools.usecase.GetSchoolDetails
import com.example.nycschools.usecase.GetSchoolDetailsImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
interface SchoolModule {
    @Binds
    fun bindsSchoolDetailRepository(impl: SchoolDetailRepositoryImpl): SchoolDetailRepository

    @Binds
    fun bindsGetSchoolDetails(impl: GetSchoolDetailsImpl): GetSchoolDetails

    companion object {
        @Provides
        fun providesMoshi(): Moshi {
            return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        @Provides
        fun providesRetrofit(moshi: Moshi): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/resource/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        @Provides
        fun providesSchoolService(retrofit: Retrofit): SchoolService = retrofit.create()
    }
}
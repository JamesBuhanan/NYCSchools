package com.example.nycschools.di

import com.example.nycschools.service.SchoolService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
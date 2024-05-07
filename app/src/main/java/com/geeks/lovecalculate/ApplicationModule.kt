package com.geeks.lovecalculate

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideApi():LoveApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(LoveApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOnBoardPreference(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences("PREF_KEY",Context.MODE_PRIVATE)
    }

}
package com.geeks.lovecalculate.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.geeks.lovecalculate.LoveApiService
import com.geeks.lovecalculate.data.local.dao.LoveDao
import com.geeks.lovecalculate.data.local.database.LoveDatabase
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
    fun provideApi(): LoveApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(LoveApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOnBoardPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("PREF_KEY", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideLoveDatabase(@ApplicationContext context: Context): LoveDatabase {
        return Room.databaseBuilder(
            context, LoveDatabase::class.java,
            "love_database"
        ).allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideLoveDao(loveDatabase: LoveDatabase): LoveDao {
        return loveDatabase.dao()
    }

}
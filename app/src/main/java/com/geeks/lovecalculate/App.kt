package com.geeks.lovecalculate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@HiltAndroidApp
class App : Application(){
    var api :LoveApiService?=null
    override fun onCreate() {
        super.onCreate()
         val retrofit = Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(LoveApiService::class.java)
    }
}
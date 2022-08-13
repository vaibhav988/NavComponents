package com.example.navcomponents.repository

import com.example.navcomponents.repository.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(API.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}
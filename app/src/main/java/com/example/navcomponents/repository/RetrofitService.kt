package com.example.navcomponents.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}
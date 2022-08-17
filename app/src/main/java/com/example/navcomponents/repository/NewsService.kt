package com.example.kotlin_listadapter

import com.example.navcomponents.data.Model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

     @GET("everything")
     suspend fun getNews(@Query("page")  page : Int ,@Query("pageSize") pageSize : Int  ,
                         @Query("apiKey") apiKey : String,
                         @Query("domains") domain: String
                        ):Response<Model>


     @GET("top-headlines")
     suspend fun getHeadlines(@Query("country") country : String ,@Query("apiKey") apiKey : String) : Response<Model>


}
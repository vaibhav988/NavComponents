package com.example.navcomponents.repository

import com.example.kotlin_listadapter.NewsService
import com.example.navcomponents.data.Articles


class NewsRepository {


    companion object{

        suspend fun getHeadlines(country : String):List<Articles>?
        {
            val newsmodel = RetrofitService.getInstance().create(NewsService :: class.java)
                .getHeadlines(country , Api.apiKey)
            return newsmodel.body()?.articles
        }
    }

}
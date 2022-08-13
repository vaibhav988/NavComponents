package com.example.navcomponents.repository

import com.example.navcomponents.data.Articles
import com.example.navcomponents.data.Model
import com.example.kotlin_listadapter.newsService
import retrofit2.Response

class NewsRepository {


    companion object{

        suspend fun getNews( page : Int ,  pagesize : Int): List<Articles>?
        {
            val newsModel: Response<Model> =
                RetrofitService.getInstance().create(newsService :: class.java)
                    .getNews(page,pagesize, API.apiKey,
           "techcrunch.com" )

            return newsModel.body()?.articles
        }

        suspend fun getHeadlines(country : String):List<Articles>?
        {
            val newsmodel = RetrofitService.getInstance().create(newsService :: class.java)
                .getHeadlines(country , API.apiKey)
            return newsmodel.body()?.articles
        }
    }

}
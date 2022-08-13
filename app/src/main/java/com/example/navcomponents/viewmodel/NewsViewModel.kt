package com.example.navcomponents.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navcomponents.data.Articles
import com.example.navcomponents.repository.NewsRepository
import kotlinx.coroutines.launch


class NewsViewModel : ViewModel() {

//    fun fetchNewsViaPaging() : LiveData<PagingData<Articles>> {
//        return Pager(
//            config = PagingConfig(10 , maxSize = 100),
//            pagingSourceFactory = { PagingDataSource() }
//        ).liveData.cachedIn(viewModelScope)
//    }
     var listArticles = MutableLiveData<List<Articles>>()
    fun fetchHeadlines(str : String) {
        viewModelScope.launch {
            listArticles.postValue(NewsRepository.getHeadlines(str))

        }

    }

}
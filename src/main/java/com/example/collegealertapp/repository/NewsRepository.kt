package com.example.collegealertapp.repository

import androidx.room.Query
import com.example.collegealertapp.API.RetrofitInstance
import com.example.collegealertapp.db.ArticleDatabase
import com.example.collegealertapp.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository(val db:ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String,pageNumber: Int)=
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String,pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article)= db.getArticlesDao().upsert(article)

    fun getFavouriteNews()=db.getArticlesDao().getAllArticles()

    suspend fun deleteArticle(article: Article)=db.getArticlesDao().deleteArticle(article)

}
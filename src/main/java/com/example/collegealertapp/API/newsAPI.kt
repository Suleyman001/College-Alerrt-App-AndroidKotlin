package com.example.collegealertapp.API

import com.example.collegealertapp.models.NewsResponse
import com.example.collegealertapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Locale.IsoCountryCode

interface newsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        countryCode: String = "hu",
        @Query("page")
        pageNumber: Int=1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int=1,
        @Query("apiKey")
        apiKey: String= API_KEY
    ):Response<NewsResponse>

}
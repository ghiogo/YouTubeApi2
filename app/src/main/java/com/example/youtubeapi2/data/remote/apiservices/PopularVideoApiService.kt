package com.example.youtubeapi2.data.remote.apiservices

import com.example.youtubeapi2.model.Response
import com.example.youtubeapi2.model.YoutubeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularVideoApiService {

    @GET("videos")
    suspend fun fetchPopularVideo(
        @Query("regionCode") regionCode: String = "ru",
        @Query("part") part: String = "snippet,statistics",
        @Query("chart") chart: String = "mostPopular",
        @Query("pageToken") pageToken: String
    ): Response<YoutubeModel>
}
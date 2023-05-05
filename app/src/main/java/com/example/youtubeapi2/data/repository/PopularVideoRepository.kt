package com.example.youtubeapi2.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.youtubeapi2.data.remote.apiservices.PopularVideoApiService
import com.example.youtubeapi2.data.repository.pagingsource.PopularVideoPagingSource
import javax.inject.Inject

class PopularVideoRepository @Inject constructor(
    private val popularVideoApiService: PopularVideoApiService
) {

    fun fetchVideos() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 20)
    ) {
        PopularVideoPagingSource(popularVideoApiService)
    }.liveData
}
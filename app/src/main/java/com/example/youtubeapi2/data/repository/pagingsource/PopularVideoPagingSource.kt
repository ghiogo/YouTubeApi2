package com.example.youtubeapi2.data.repository.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.youtubeapi2.data.remote.apiservices.PopularVideoApiService
import com.example.youtubeapi2.model.YoutubeModel

private const val PAGE_TOKEN = " "

class PopularVideoPagingSource(private val popularVideoApiService: PopularVideoApiService) :
    PagingSource<String, YoutubeModel>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, YoutubeModel> {
        return try {
            val startPage = params.key ?: PAGE_TOKEN
            val response = popularVideoApiService.fetchPopularVideo(
                pageToken = startPage
            )
            val nextPage = if (response.items.isEmpty()) null else response.nextPageToken
            val prevPage = if (startPage == PAGE_TOKEN) null else response.prevPageToken

            LoadResult.Page(
                data = response.items,
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, YoutubeModel>): String? {
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey
        }
        return null
    }
}
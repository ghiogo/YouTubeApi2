package com.example.youtubeapi2.ui.fragment

import androidx.lifecycle.ViewModel
import com.example.youtubeapi2.data.repository.PopularVideoRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularVideoViewModel @Inject constructor(
    private val repository: PopularVideoRepository,
) : ViewModel() {

    fun fetchPopularVideo() = repository.fetchVideos()
}
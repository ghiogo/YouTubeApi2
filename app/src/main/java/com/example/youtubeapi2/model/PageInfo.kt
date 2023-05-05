package com.example.youtubeapi2.model

import com.google.gson.annotations.SerializedName

data class PageInfo(
    @SerializedName("totalResults")
    val totalResults: String,
    @SerializedName("resultsPerPage")
    val resultsPerPage: String
)
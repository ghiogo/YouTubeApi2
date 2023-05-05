package com.example.youtubeapi2.model

import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("viewCount")
    val viewCount: String? = null,
    @SerializedName("likeCount")
    val likeCount: String
)
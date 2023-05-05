package com.example.youtubeapi2.model

import com.google.gson.annotations.SerializedName
import com.example.youtubeapi2.base.IBaseDiffModel

data class YoutubeModel(
    @SerializedName("id")
    override val id: String,
    @SerializedName("snippet")
    val snippet: Snippet,
    @SerializedName("statistics")
    val statistics: Statistics
) : IBaseDiffModel
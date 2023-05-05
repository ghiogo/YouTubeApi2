package com.example.youtubeapi2.model

import com.google.gson.annotations.SerializedName

data class Standard(
    @SerializedName("width")
    val width: Int = 0,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("height")
    val height: Int = 0
)
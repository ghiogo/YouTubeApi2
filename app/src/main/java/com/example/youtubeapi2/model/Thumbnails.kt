package com.example.youtubeapi2.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("maxres")
    val maxRes: MaxRes,
    @SerializedName("standard")
    val standard: Standard
)
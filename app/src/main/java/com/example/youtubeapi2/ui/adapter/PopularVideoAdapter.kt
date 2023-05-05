package com.example.youtubeapi2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi.databinding.ItemVideoBinding
import com.example.youtubeapi2.base.BaseDiffUtilItemCallback
import com.example.youtubeapi2.model.YoutubeModel

class PopularVideoAdapter :
    PagingDataAdapter<YoutubeModel, PopularVideoAdapter.VideoViewHolder>(BaseDiffUtilItemCallback()) {

    inner class VideoViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: YoutubeModel) = with(binding) {
            tvAuthorName.text = item.snippet.channelTitle
            Glide.with(binding.ivCover).load(item.snippet.thumbnails.standard.url)
                .into(ivCover)
            tvName.text = item.snippet.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}
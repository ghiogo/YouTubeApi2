package com.example.youtubeapi2.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentPopularVideoBinding
import com.example.youtubeapi2.base.BaseFragment
import com.example.youtubeapi2.ui.adapter.PopularVideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularVideoFragment :
    BaseFragment<FragmentPopularVideoBinding, PopularVideoViewModel>(R.layout.fragment_popular_video) {

    override val binding by viewBinding(FragmentPopularVideoBinding::bind)
    override val viewModel: PopularVideoViewModel by viewModels()
    private val adapter = PopularVideoAdapter()

    override fun initialize() {
        binding.rvYoutube.adapter = adapter
    }

    override fun setupSubscribes() {
        viewModel.fetchPopularVideo().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        }
    }
}
package com.project.githubusersearch.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.project.githubusersearch.R
import com.project.githubusersearch.data.remote.Result
import com.project.githubusersearch.data.remote.model.DetailUserResponse
import com.project.githubusersearch.databinding.FragmentUserDetailBinding
import com.project.githubusersearch.util.ImageCornerOptions
import com.project.githubusersearch.util.loadImage
import com.project.githubusersearch.util.viewBinding
import com.project.githubusersearch.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    private val binding by viewBinding<FragmentUserDetailBinding>()
    private val viewModel by viewModels<MainViewModel>()
    private val args by navArgs<UserDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        initViewModel()
        initUserDetailCallback()
    }

    private fun initData(item: DetailUserResponse?) {
        binding.apply {
            item?.let {
                ivUser.loadImage(
                    it.avatarUrl,
                    scaleType = ImageView.ScaleType.CENTER_CROP,
                    corner = ImageCornerOptions.CIRCLE
                )
                tvName.text = it.name
                tvCompany.text = it.company
                tvLocation.text = it.location
                tvBio.text = it.bio
                tvRepository.text = it.publicRepos.toString()
                tvFollowers.text = it.followers.toString()
                tvFollowing.text = it.following.toString()
            }
        }
    }

    private fun initViewModel() {
        viewModel.requestDetailUser(args.username.orEmpty())
    }

    private fun initUserDetailCallback() {
        viewModel.userDetail.observe(viewLifecycleOwner) { result ->
            when(result) {
                is Result.Loading -> {}
                is Result.Success -> {
                    initData(result.results)
                }
                is Result.Error<*> -> {}
                else -> {}
            }
        }
    }

}
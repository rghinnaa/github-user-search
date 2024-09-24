package com.project.githubusersearch.ui.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.project.githubusersearch.R
import com.project.githubusersearch.databinding.FragmentSearchBinding
import com.project.githubusersearch.ui.adapter.PagingLoadStateAdapter
import com.project.githubusersearch.ui.adapter.SearchPagingAdapter
import com.project.githubusersearch.ui.adapter.UserPagingAdapter
import com.project.githubusersearch.util.addDelayOnTypeWithScope
import com.project.githubusersearch.util.drawable
import com.project.githubusersearch.util.hideKeyboard
import com.project.githubusersearch.util.navController
import com.project.githubusersearch.util.navigateOrNull
import com.project.githubusersearch.util.viewBinding
import com.project.githubusersearch.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding<FragmentSearchBinding>()
    private val viewModel by viewModels<MainViewModel>()

    private val searchAdapter = SearchPagingAdapter()
    private val userAdapter = UserPagingAdapter()

    private var key = ""

    private val onImeSearchClicked = TextView.OnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            searchEvent(v, binding.etSearch.text.toString())

            return@OnEditorActionListener true
        }
        false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        initSearchImeOption()
        initSearchDelayOnType()
        initUserCallback()
    }

    private fun initSearchAdapter() {
        binding.rvUser.adapter = searchAdapter.withLoadStateFooter(
            PagingLoadStateAdapter { searchAdapter.retry() }
        )

        searchAdapter.setOnItemClickListener {
            binding.etSearch.setText("")
            activity?.hideKeyboard(binding.etSearch)
            navController.navigateOrNull(
                SearchFragmentDirections.actionUserDetail(it.login)
            )
        }
    }

    private fun initUserAdapter() {
        binding.rvUser.adapter = userAdapter.withLoadStateFooter(
            PagingLoadStateAdapter { userAdapter.retry() }
        )

        userAdapter.setOnItemClickListener {
            binding.etSearch.setText("")
            binding.etSearch.clearFocus()
            activity?.hideKeyboard(binding.etSearch)

            navController.navigateOrNull(
                SearchFragmentDirections.actionUserDetail(it.username)
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUserCallback() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.requestUserListPaging.observe(viewLifecycleOwner) { result ->
                initUserAdapter()
                userAdapter.submitData(lifecycle, result)
                userAdapter.notifyDataSetChanged()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initSearchCallback() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.requestSearchUserPaging(key).observe(viewLifecycleOwner) { result ->
                initSearchAdapter()
                searchAdapter.submitData(lifecycle, result)
                searchAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initSearchImeOption() {
        binding.etSearch.apply {
            clearFocus()
            setOnEditorActionListener(onImeSearchClicked)
        }
    }

    private fun initSearchDelayOnType() {
        binding.etSearch.addDelayOnTypeWithScope(200, viewLifecycleOwner.lifecycleScope) {
            binding.boxSearch.endIconDrawable = context?.drawable(
                if (binding.etSearch.text.isNullOrEmpty()) R.drawable.ic_search else R.drawable.ic_close
            )
        }
        binding.boxSearch.setEndIconOnClickListener {
            if (!binding.etSearch.text.isNullOrEmpty()) {
                binding.etSearch.text?.clear()
                initUserCallback()
            }
        }
    }

    private fun searchEvent(v: TextView, keyword: String) {
        activity?.hideKeyboard(v)
        key = keyword
        initSearchCallback()
    }

}
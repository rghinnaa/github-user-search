package com.project.githubusersearch.ui

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
import com.project.githubusersearch.util.hideKeyboard
import com.project.githubusersearch.util.viewBinding
import com.project.githubusersearch.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding<FragmentSearchBinding>()
    private val viewModel by viewModels<MainViewModel>()

    private val searchAdapter = SearchPagingAdapter()

    private var key = ""

    private val onImeSearchClicked = TextView.OnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            val searchText = binding.etSearch.text.toString()
            searchEvent(v, searchText)

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
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvUser.adapter = searchAdapter.withLoadStateFooter(
            PagingLoadStateAdapter { searchAdapter.retry() }
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initSearchCallback() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.requestSearchUserPaging(key).observe(viewLifecycleOwner) { result ->
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

    private fun searchEvent(v: TextView, keyword: String) {
        activity?.hideKeyboard(v)
        key = keyword
        initSearchCallback()
    }

}
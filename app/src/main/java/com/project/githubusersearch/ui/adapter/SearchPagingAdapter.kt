package com.project.githubusersearch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.githubusersearch.data.remote.model.SearchUserResponse
import com.project.githubusersearch.databinding.ItemSearchBinding
import com.project.githubusersearch.util.ImageCornerOptions
import com.project.githubusersearch.util.loadImage

class SearchPagingAdapter :
    PagingDataAdapter<SearchUserResponse.Item, SearchPagingAdapter.ViewHolder>(
    differ
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSearchBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null) {
            holder.bind(item)
        }
    }

    inner class ViewHolder(private val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchUserResponse.Item) {
            binding.run {

                ivUser.loadImage(
                    item.avatarUrl,
                    scaleType = ImageView.ScaleType.CENTER_CROP,
                    corner = ImageCornerOptions.CIRCLE
                )
                tvUser.text = item.login

                root.setOnClickListener {
                    onItemClickListener?.invoke(item)
                }
            }
        }
    }

    private var onItemClickListener: ((SearchUserResponse.Item) -> Unit)? = null

    fun setOnItemClickListener(listener: (SearchUserResponse.Item) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val differ = object : DiffUtil.ItemCallback<SearchUserResponse.Item>() {
            override fun areItemsTheSame(oldItem: SearchUserResponse.Item, newItem: SearchUserResponse.Item): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: SearchUserResponse.Item, newItem: SearchUserResponse.Item): Boolean =
                oldItem == newItem
        }
    }

}
package com.project.githubusersearch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.githubusersearch.R
import com.project.githubusersearch.data.remote.model.PublicRepositoryUserResponse
import com.project.githubusersearch.data.remote.model.SearchUserResponse
import com.project.githubusersearch.databinding.ItemRepositoryBinding
import com.project.githubusersearch.databinding.ItemSearchBinding
import com.project.githubusersearch.util.Const
import com.project.githubusersearch.util.ImageCornerOptions
import com.project.githubusersearch.util.convertDate
import com.project.githubusersearch.util.dateFormatter
import com.project.githubusersearch.util.loadImage

class RepositoryPagingAdapter :
    PagingDataAdapter<PublicRepositoryUserResponse, RepositoryPagingAdapter.ViewHolder>(
    differ
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRepositoryBinding.inflate(
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

    inner class ViewHolder(private val binding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PublicRepositoryUserResponse) {
            binding.run {

                tvName.text = item.name
                if(item.description.isNullOrEmpty()) tvDesc.isVisible = false
                tvDesc.text = item.description
                tvUpdatedAt.text = binding.root.context.getString(
                    R.string.update_at,
                    dateFormatter(Const.DATE_FORMAT).format(convertDate(item.updatedAt.toString())))

                root.setOnClickListener {
                    onItemClickListener?.invoke(item)
                }
            }
        }
    }

    private var onItemClickListener: ((PublicRepositoryUserResponse) -> Unit)? = null

    fun setOnItemClickListener(listener: (PublicRepositoryUserResponse) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val differ = object : DiffUtil.ItemCallback<PublicRepositoryUserResponse>() {
            override fun areItemsTheSame(oldItem: PublicRepositoryUserResponse, newItem: PublicRepositoryUserResponse): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PublicRepositoryUserResponse, newItem: PublicRepositoryUserResponse): Boolean =
                oldItem == newItem
        }
    }

}
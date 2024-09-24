package com.project.githubusersearch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.githubusersearch.data.local.entity.User
import com.project.githubusersearch.databinding.ItemSearchBinding
import com.project.githubusersearch.util.ImageCornerOptions
import com.project.githubusersearch.util.loadImage

class UserPagingAdapter :
    PagingDataAdapter<User, UserPagingAdapter.ViewHolder>(
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
        fun bind(item: User) {
            binding.run {

                ivUser.loadImage(
                    item.avatar,
                    scaleType = ImageView.ScaleType.CENTER_CROP,
                    corner = ImageCornerOptions.CIRCLE
                )
                tvUser.text = item.username

                root.setOnClickListener {
                    onItemClickListener?.invoke(item)
                }
            }
        }
    }

    private var onItemClickListener: ((User) -> Unit)? = null

    fun setOnItemClickListener(listener: (User) -> Unit) {
        onItemClickListener = listener
    }

    fun getItemAtPosition(position: Int): User? {
        return getItem(position)
    }

    companion object {
        private val differ = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem == newItem
        }
    }

}
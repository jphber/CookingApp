package com.jeanbernuy.cookingapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbernuy.cookingapp.core.BaseViewHolder
import com.jeanbernuy.cookingapp.data.model.Item
import com.jeanbernuy.cookingapp.databinding.TagRowBinding

class TagAdapter(
    private val context: Context,
    private val listTags: List<Item>?
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val item = TagRowBinding.inflate(LayoutInflater.from(context), parent, false)
        return TagViewHolder(item)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is TagAdapter.TagViewHolder -> {
                holder.bind(listTags?.get(position), position)
            }
        }
    }

    override fun getItemCount() = listTags?.size ?: 0

    inner class TagViewHolder(private val binding: TagRowBinding) :
        BaseViewHolder<Item?>(binding.root) {
        override fun bind(item: Item?, position: Int) {
            binding.txtTagName.text = item?.name
        }

    }
}
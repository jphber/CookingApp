package com.jeanbernuy.cookingapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jeanbernuy.cookingapp.R
import com.jeanbernuy.cookingapp.RecipeQuery
import com.jeanbernuy.cookingapp.core.BaseViewHolder
import com.jeanbernuy.cookingapp.databinding.RecipeRowBinding

class RecipeAdapter(
    private val context: Context,
    private val listaRecipes: List<RecipeQuery.Item?>,
    private val itemClickListener: OnClickRecipeListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnClickRecipeListener {
        fun onClickRecipe(item: RecipeQuery.Item?, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = RecipeRowBinding.inflate(LayoutInflater.from(context), parent, false)
        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is RecipeAdapter.MainViewHolder -> holder.bind(listaRecipes[position], position)
        }
    }

    override fun getItemCount(): Int {
        return listaRecipes.size
    }

    inner class MainViewHolder(val binding: RecipeRowBinding) :
        BaseViewHolder<RecipeQuery.Item?>(binding.root) {
        override fun bind(item: RecipeQuery.Item?, position: Int) {
            Glide.with(context).load(item?.photo()?.url()).centerCrop()
                .placeholder(R.drawable.ic_launcher_background).into(binding.imvRecipe)
            binding.txtTitle.text = item?.title()
            binding.root.setOnClickListener {
                itemClickListener.onClickRecipe(item, position)
                }
        }

    }
}
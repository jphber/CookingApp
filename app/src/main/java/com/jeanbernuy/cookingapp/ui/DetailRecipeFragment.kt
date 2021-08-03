package com.jeanbernuy.cookingapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jeanbernuy.cookingapp.data.model.RecipeItem
import com.jeanbernuy.cookingapp.databinding.FragmentDetailRecipeBinding

/**
 * A simple [Fragment] that shows Detail of Recipe.
 *
 * by: Jean Bernuy
 */
class DetailRecipeFragment : Fragment() {

    private var _binding: FragmentDetailRecipeBinding? = null
    private val binding get() = _binding!!
    private lateinit var detailRecipeItem: RecipeItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            DetailRecipeFragmentArgs.fromBundle(it).also { args ->
                detailRecipeItem = args.detailRecipe
                Log.d("DATA", detailRecipeItem.toString())

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailRecipeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecipeDetail()
    }

    private fun setupRecipeDetail() {
        Glide.with(requireContext()).load(detailRecipeItem.photo?.url).centerCrop().into(binding.ivRecipePhoto)
        binding.tvRecipeName.text = detailRecipeItem.title
        binding.tvRecipeDescription.text = detailRecipeItem.description
        //binding.tvRecipeTags.text = detailRecipeItem?.tagsCollection?.items?.get(0)?.name
        binding.tvRecipeChefName.text = detailRecipeItem.chef.name
    }
}
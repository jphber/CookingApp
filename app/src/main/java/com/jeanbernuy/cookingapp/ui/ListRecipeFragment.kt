package com.jeanbernuy.cookingapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeanbernuy.cookingapp.core.Resource
import com.jeanbernuy.cookingapp.databinding.FragmentMainBinding
import com.jeanbernuy.cookingapp.ui.adapters.RecipeAdapter
import com.jeanbernuy.cookingapp.ui.viewmodel.ListRecipeViewModel

/**
 * A simple [Fragment] that list all Recipes.
 *
 * by: Jean Bernuy
 */
class ListRecipeFragment : Fragment() {

    private val viewModel: ListRecipeViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {

        binding.rvRecipes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRecipes.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        viewModel.listRecipes.observe(viewLifecycleOwner, Observer {result ->
            when (result){
                is Resource.Success -> {
                    binding.rvRecipes.adapter = RecipeAdapter(requireContext(), result.data.recipeCollection()!!.items())
                }
            }
        })
    }

}
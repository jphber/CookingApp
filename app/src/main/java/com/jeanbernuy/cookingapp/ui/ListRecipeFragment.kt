package com.jeanbernuy.cookingapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jeanbernuy.cookingapp.R
import com.jeanbernuy.cookingapp.ui.viewmodel.ListRecipeViewModel

/**
 * A simple [Fragment] that list all Recipes.
 *
 * by: Jean Bernuy
 */
class ListRecipeFragment : Fragment() {

    private val viewModel:ListRecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }
    
    private fun setupViews() {
        viewModel.listRecipes.observe(viewLifecycleOwner, Observer{
            Log.d("Response",it.toString())
        })
    }
    
}
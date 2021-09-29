package com.lja.numeriqsampleapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.lja.numeriqsampleapp.R
import com.lja.numeriqsampleapp.viewmodel.ArticlesViewModel
import com.lja.numeriqsampleapp.viewmodel.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: ArticlesViewModel by viewModel()

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listArticlesFlow.collect { state ->
                when (state) {
                    State.Loading -> Log.d("LJA", "loading")
                    is State.Error -> {
                        Log.d("LJA", "error")
                    }
                    is State.Success -> {
                        Log.d("LJA", "succeed")
                    }
                }
            }
        }
    }
}
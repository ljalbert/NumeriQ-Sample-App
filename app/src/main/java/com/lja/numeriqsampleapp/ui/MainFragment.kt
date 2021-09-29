package com.lja.numeriqsampleapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lja.numeriqsampleapp.R
import com.lja.numeriqsampleapp.ui.adapter.ArticleAdapter
import com.lja.numeriqsampleapp.viewmodel.ArticlesViewModel
import com.lja.numeriqsampleapp.viewmodel.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: ArticlesViewModel by viewModel()

    private var viewHolder: ViewHolder? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        viewHolder = ViewHolder(
            view,
            ArticleAdapter()
        ).apply {
            initRecyclerView(requireContext())
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listArticlesFlow.collect { state ->
                when (state) {
                    State.Loading -> displayLoading(true)
                    is State.Error -> {
                        displayLoading(false)
                        displayError()
                    }
                    is State.Success -> {
                        displayLoading(false)
                        viewHolder?.adapter?.setItems(state.data)
                    }
                }
            }
        }
    }

    private fun ViewHolder.initRecyclerView(context: Context) {
        val viewHolderAdapter = this.adapter
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = viewHolderAdapter
        }
    }

    private class ViewHolder(view: View, val adapter: ArticleAdapter) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_articles)
        val progressBar: ProgressBar = view.findViewById(R.id.pb_articles)
    }

    private fun displayLoading(display: Boolean) {
        viewHolder?.progressBar?.isVisible = display
    }

    private fun displayError() {
        Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
    }
}
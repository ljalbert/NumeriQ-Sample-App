package com.lja.numeriqsampleapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lja.numeriqsampleapp.R
import com.lja.numeriqsampleapp.service.model.shared.ArticleShared

class ArticleAdapter : RecyclerView.Adapter<ArticleViewHolder>() {

    private val items = mutableListOf<ArticleShared>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
     * Set items used by the adapter
     * @param items the items list
     */
    fun setItems(items: List<ArticleShared>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
        //TODO implement diffUtils.callback to improve performance
    }

    override fun getItemCount() = items.size
}
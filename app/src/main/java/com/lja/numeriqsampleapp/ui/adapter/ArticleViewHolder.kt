package com.lja.numeriqsampleapp.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lja.numeriqsampleapp.R
import com.lja.numeriqsampleapp.service.model.shared.ArticleShared
import com.squareup.picasso.Picasso

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.tv_article_title)
    private val source: TextView = itemView.findViewById(R.id.tv_article_source)
    private val description: TextView = itemView.findViewById(R.id.tv_article_description)
    private val image: ImageView = itemView.findViewById(R.id.iv_article)


    fun bind(item: ArticleShared) {
        title.text = item.title
        source.text = item.source
        description.text = item.description

        Picasso.get().load(item.urlToImage).error(R.drawable.ic_launcher_background)
            .resize(1024, 1024)
            .centerCrop()
            .onlyScaleDown().into(image)
    }
}
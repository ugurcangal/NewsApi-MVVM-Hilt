package com.example.newsapiapp.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.newsapiapp.data.model.Article
import com.example.newsapiapp.databinding.ListRecyclerviewItemBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class ListFragmentRecyclerAdapter(val articles: List<Article>, var onClick: (Int) -> Unit) : RecyclerView.Adapter<ListFragmentRecyclerAdapter.ViewHolder>()  {

    lateinit var glide: RequestManager

    inner class ViewHolder(val binding: ListRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.apply {
                itemTextView.text = articles[position].title
                glide.load(articles[position].urlToImage).into(itemImageView)
                constraintLayout.setOnClickListener {
                    onClick(position)
                }
            }
        }
    }


}
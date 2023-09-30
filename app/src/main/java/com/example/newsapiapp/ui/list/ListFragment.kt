package com.example.newsapiapp.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.example.newsapiapp.R
import com.example.newsapiapp.data.model.Article
import com.example.newsapiapp.databinding.FragmentListBinding
import com.example.newsapiapp.ui.list.adapter.ListFragmentRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    @Inject
    lateinit var glide: RequestManager

    val listViewModel : ListViewModel by viewModels()
    private var fragmentBinding: FragmentListBinding? = null
    private lateinit var listFragmentRecyclerAdapter: ListFragmentRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding = FragmentListBinding.bind(view)
//        fragmentBinding = binding
        observeViewModel()

    }

    private fun observeViewModel(){
        listViewModel.apply {
            allTopHeadlines.observe(viewLifecycleOwner, Observer {
                initListRV(it.articles)
            })
        }
    }

    private fun initListRV(articles: List<Article>){
        fragmentBinding?.apply {
            listFragmentRecyclerAdapter = ListFragmentRecyclerAdapter(articles) {
                val position = articles[it]
                val action = ListFragmentDirections.actionListFragmentToDetailsFragment(position.title,position.urlToImage,position.description,position.publishedAt)
                findNavController().navigate(action)
            }
            listFragmentRecyclerAdapter.glide = glide
            listRV.adapter = listFragmentRecyclerAdapter
            listRV.layoutManager = LinearLayoutManager(context)
        }
    }

}
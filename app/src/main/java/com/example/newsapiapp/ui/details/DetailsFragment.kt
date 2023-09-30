package com.example.newsapiapp.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.newsapiapp.R
import com.example.newsapiapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment  : Fragment(R.layout.fragment_details) {

    @Inject
    lateinit var glide: RequestManager

    private var fragmentBinding: FragmentDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding = FragmentDetailsBinding.bind(view)


        arguments?.let {
            val title = DetailsFragmentArgs.fromBundle(it).title
            val imageUrl = DetailsFragmentArgs.fromBundle(it).imageUrl
            val desc = DetailsFragmentArgs.fromBundle(it).desc
            val publishDate = DetailsFragmentArgs.fromBundle(it).publishDate
            fragmentBinding?.apply {
                titleTextView.text = title
                descTextView.text = desc
                glide.load(imageUrl).into(imageView)
                this.publishDate.text = publishDate
            }
        }



    }

}
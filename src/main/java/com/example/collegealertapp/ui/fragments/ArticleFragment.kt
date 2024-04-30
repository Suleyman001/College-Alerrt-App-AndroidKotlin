package com.example.collegealertapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
import android.view.View
//import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.collegealertapp.R
import com.example.collegealertapp.ui.NewsActivity
import com.example.collegealertapp.ui.NewsViewModel
import com.example.collegealertapp.databinding.FragmentArticleBinding
//import com.example.newsprojectpractice.R
//import com.example.newsprojectpractice.databinding.FragmentArticleBinding
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var newsViewModel: NewsViewModel
     private val args: ArticleFragmentArgs by navArgs()
    private lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel=(activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient= WebViewClient()
            loadUrl(article.url)
        }

        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to Favourites ", Snackbar.LENGTH_SHORT).show()
        }

    }

}
package com.example.navcomponents.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navcomponents.R
import com.example.navcomponents.data.Articles
import com.example.navcomponents.databinding.FragmentDetailFragmentBinding


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailFragmentBinding
    lateinit var argument: Bundle
    lateinit var articles: Articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailFragmentBinding.inflate(LayoutInflater.from(requireContext()) , container , false)
        argument = requireArguments()
        articles = argument.getSerializable("news") as Articles
        binding.news = articles
        return binding.root.rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
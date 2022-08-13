package com.example.navcomponents.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navcomponents.R
import com.example.navcomponents.databinding.FragmentListFragmentBinding
import com.example.navcomponents.viewmodel.NewsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [list_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class
ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
      private lateinit var binding : FragmentListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListFragmentBinding.inflate(LayoutInflater.from(requireContext()), container , false)

        return binding.root.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController : NavController = Navigation.findNavController(view)
//        binding.text.setOnClickListener(
//            {
//                navController.navigate(R.id.action_listFragment_to_detailFragment)
//            }
//        )

         val viewModel : NewsViewModel = NewsViewModel()
         val adapter : NewsPageAdapter =  NewsPageAdapter(requireContext() , navController)
         binding.recycler.apply {
             this.adapter = adapter
             this.layoutManager = LinearLayoutManager(requireContext())
         }
        viewModel.fetchHeadlines("in")
        viewModel.listArticles.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }

}
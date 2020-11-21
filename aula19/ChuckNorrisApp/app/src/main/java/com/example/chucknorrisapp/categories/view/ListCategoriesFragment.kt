package com.example.chucknorrisapp.categories.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.R
import com.example.chucknorrisapp.categories.repository.CategoriesRepository
import com.example.chucknorrisapp.categories.viewmodel.CategoriesViewModel


class ListCategoriesFragment : Fragment() {

    private lateinit var _viewModel:CategoriesViewModel
    private lateinit var _view:View
    private lateinit var _listRecyclerView:RecyclerView
    private lateinit var _navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _view=inflater.inflate(R.layout.fragment_list_categories, container, false)
        return _view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _listRecyclerView = _view.findViewById(R.id.listCategories)
        _navController = Navigation.findNavController(_view)

        _viewModel = ViewModelProvider(
            this,
            CategoriesViewModel.CategoryViewModelFactory(CategoriesRepository())
        ).get(CategoriesViewModel::class.java)

        _viewModel.getCategories().observe(viewLifecycleOwner, Observer{
            getList(it)
        })

    }

    private fun getList(categories:List<String>) {
        val viewManager = LinearLayoutManager(_view.context)
        val viewAdapter = ListCategoriesAdapter(categories){
            val bundle = bundleOf("CATEGORY" to it)
            _navController.navigate(R.id.jokesFragment,bundle)
        }

        _listRecyclerView.addItemDecoration(DividerItemDecoration(_listRecyclerView.context,DividerItemDecoration.VERTICAL))

        _listRecyclerView.apply{
            setHasFixedSize(true)
            layoutManager=viewManager
            adapter=viewAdapter
        }
    }


    companion object {
        fun newInstance() = ListCategoriesFragment()
    }
}
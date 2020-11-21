package com.example.chucknorrisapp.jokes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisapp.R
import com.example.chucknorrisapp.categories.viewmodel.CategoriesViewModel
import com.example.chucknorrisapp.jokes.model.JokesModel
import com.example.chucknorrisapp.jokes.repository.JokesRepository
import com.example.chucknorrisapp.jokes.viewmodel.JokesViewModel
import com.squareup.picasso.Picasso

class JokesFragment : Fragment() {
    private lateinit var _viewModel: JokesViewModel
    private lateinit var _view:View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _view = inflater.inflate(R.layout.fragment_jokes, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModel =ViewModelProvider(
            this,
            JokesViewModel.JokeViewModelFactory(JokesRepository())
        ).get(JokesViewModel::class.java)


        arguments?.getString(getString(R.string.CATEGORY))?.let { category ->
            _viewModel.getJokes(category).observe(viewLifecycleOwner, Observer{ jokeModel ->
                showInformations(jokeModel)
            })
        }
    }

    private fun showInformations(jokeModel: JokesModel) {
        val message = _view.findViewById<TextView>(R.id.txtMessage)
        val img = _view.findViewById<ImageView>(R.id.imageView)

        message.text = jokeModel.value

        Picasso.get().load(jokeModel.icon_url).into(img)
    }

    companion object {

        fun newInstance() = JokesFragment()
    }
}
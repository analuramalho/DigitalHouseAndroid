package com.example.exemplomvvm.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.exemplomvvm.R
import com.example.exemplomvvm.home.repository.TarefaRepository
import com.example.exemplomvvm.home.viewmodel.TarefaViewModel

class HomeFragment : Fragment() {
    lateinit var minhaView: View
    lateinit var viewModel:TarefaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView= inflater.inflate(R.layout.fragment_home, container, false)
        return minhaView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            TarefaViewModel.TarefaViewModelFactory(TarefaRepository())
        ).get(TarefaViewModel::class.java)

         viewModel.listaDeTarefasData.observe(viewLifecycleOwner, Observer {
             minhaView.findViewById<TextView>(R.id.txtTarefa).text = it[0].descricao
         })

        viewModel.obterTarefas()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }
}
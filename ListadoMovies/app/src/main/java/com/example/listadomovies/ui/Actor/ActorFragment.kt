package com.example.listadomovies.ui.Actor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listadomovies.R
import com.example.listadomovies.poko.Actor



class ActorFragment : Fragment() {

    lateinit var actoresList: List<Actor>
    lateinit var adapterActores: MyActorRecyclerViewAdapter
    lateinit var viewModel: ActorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actor_list, container, false)

        viewModel = ViewModelProvider(this).get(ActorViewModel::class.java)

        actoresList = listOf()
        adapterActores = MyActorRecyclerViewAdapter(activity as Context, actoresList)

        with(view as RecyclerView) {
            layoutManager =  LinearLayoutManager(context)
            adapter = adapterActores
        }

        viewModel.actores.observe(viewLifecycleOwner, Observer {
                listaNueva -> actoresList = listaNueva
            adapterActores.setData(listaNueva)
        })


        return view
    }

}
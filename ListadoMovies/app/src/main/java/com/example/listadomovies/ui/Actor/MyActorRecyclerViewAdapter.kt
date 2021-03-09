package com.example.listadomovies.ui.Actor

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.listadomovies.R
import com.example.listadomovies.common.Constantes
import com.example.listadomovies.poko.Actor


class MyActorRecyclerViewAdapter(
    private var activity: Context,
    private var values: List<Actor>
) : RecyclerView.Adapter<MyActorRecyclerViewAdapter.ViewHolder>() {



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nombreActor)
        val imagenActor: ImageView = view.findViewById(R.id.imagen_Actor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_actor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = values[position]
        var nombre = currentItem.name
        var avatar = Constantes.IMAGE_BASE_URL + currentItem.profile_path
        holder.name.text = nombre
        holder.imagenActor.load(avatar)
    }

    override fun getItemCount(): Int = values.size

    fun setData(listaNueva: List<Actor>?) {
        if (listaNueva != null) {
            values = listaNueva
            notifyDataSetChanged()
        }
    }


}
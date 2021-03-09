package com.example.listadomovies.ui.Actor

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listadomovies.common.Constantes
import com.example.listadomovies.poko.Actor
import com.example.listadomovies.poko.ActorResponse
import com.example.listadomovies.retrofit.ActoresService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActorViewModel:ViewModel() {


    var retrofit: Retrofit
    var actoresService: ActoresService

    private var _actores = MutableLiveData<List<Actor>>()

    val actores: LiveData<List<Actor>>
        get() = _actores

    init {
        _actores.value = listOf()
        retrofit = Retrofit.Builder()
            .baseUrl(Constantes.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        actoresService = retrofit.create(ActoresService::class.java)
        getActores()
    }

    private fun getActores() {
        actoresService.getActoresList().enqueue(object: Callback<ActorResponse> {
            override fun onResponse(call: Call<ActorResponse>, response: Response<ActorResponse>) {
                if(response.code() == 200) {
                    _actores.value = response.body()?.results
                }
            }
            override fun onFailure(call: Call<ActorResponse>, t: Throwable) {
                Log.i("Pablo","ha entrado en onFailure")
            }
        })
    }
}
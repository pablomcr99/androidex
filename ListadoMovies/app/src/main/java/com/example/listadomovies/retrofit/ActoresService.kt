package com.example.listadomovies.retrofit



import com.example.listadomovies.common.Constantes
import com.example.listadomovies.poko.ActorResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ActoresService {

    @GET("/person/popular")
    fun getActoresList(@Query("api_key") api_key:String=Constantes.API_KEY): Call<ActorResponse>

}

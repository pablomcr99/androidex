package com.example.listadomovies.poko

data class ActorResponse(
    val page: Int,
    val results: List<Actor>,
    val total_pages: Int,
    val total_results: Int
)
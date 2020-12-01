package br.com.lucolimac.desafio03.service

import br.com.lucolimac.desafio03.domain.ResultSet
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

val apiMarvelUrl = "https://gateway.marvel.com/v1/public/"

interface Repository {
    @GET("series/454/comics")
    suspend fun getComicsSpider(
        @Query("offset")
        offset: Int,
        @Query("limit")
        limit: Int,
        @Query("ts")
        ts: String,
        @Query("apikey")
        apikey: String,
        @Query("hash")
        hash: String
    ): ResultSet

    @GET("comics")
    suspend fun getComics(
        @Query("offset")
        offset: Int,
        @Query("limit")
        limit: Int,
        @Query("ts")
        ts: String,
        @Query("apikey")
        apikey: String,
        @Query("hash")
        hash: String
    ): ResultSet

    @GET("comics/{id}")
    suspend fun getComic(
        @Query("offset")
        offset: Int,
        @Query("limit")
        limit: Int,
        @Query("ts")
        ts: String,
        @Query("apikey")
        apikey: String,
        @Query("hash")
        hash: String,
        @Path("id") id: Int
    )
}

val retrofit = Retrofit.Builder()
    .baseUrl(apiMarvelUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val repository: Repository = retrofit.create(Repository::class.java)
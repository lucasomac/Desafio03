package br.com.lucolimac.desafio03.service

import br.com.lucolimac.desafio03.domain.Entities
import br.com.lucolimac.desafio03.util.API_MARVEL_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Repository {
//    @GET("series/454/comics")
//    suspend fun getComicsSpider(
//        @Query("offset")
//        offset: Int,
//        @Query("limit")
//        limit: Int,
//        @Query("ts")
//        ts: String,
//        @Query("apikey")
//        apikey: String,
//        @Query("hash")
//        hash: String
//    ): ResultSet

    @GET("comics")
    suspend fun getComics(
        @Query("offset")
        offset: Int,
        @Query("limit")
        limit: Int,
        @Query("ts")
        ts: Int,
        @Query("apikey")
        apikey: String,
        @Query("hash")
        hash: String
    ): Entities

    @GET("comics/{id}")
    suspend fun getComic(
        @Path("id") id: Int,
        @Query("ts")
        ts: Int,
        @Query("apikey")
        apikey: String,
        @Query("hash")
        hash: String
    ): Entities
}

val retrofit = Retrofit.Builder()
    .baseUrl(API_MARVEL_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val repository: Repository = retrofit.create(Repository::class.java)
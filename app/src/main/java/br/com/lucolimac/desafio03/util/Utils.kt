package br.com.lucolimac.desafio03.util

val API_MARVEL_URL = "https://gateway.marvel.com/v1/public/"
val PUBLIC_API_KEY = "f9cb9b2e474b53391d7ef0b68943eb1f"
val HASH_API = "05841f118ae7797fcb7179bc8a6924bf"
val TIME_STAMP_API = 1
var LIMIT_RETORNO = 12

fun replaceHttps(url: String): String {
    return url.replace("http://", "https://")
}
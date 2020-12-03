package br.com.lucolimac.desafio03.domain

data class Entities(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: ArrayList<Result>,
    val total: String
)

data class Result(
    val characters: Characters,
    val collectedIssues: ArrayList<CollectedIssue>,
    val collections: ArrayList<Collection>,
    val creators: Creators,
    val dates: ArrayList<Date>,
    val description: String,
    val diamondCode: String,
    val digitalId: String,
    val ean: String,
    val events: Events,
    val format: String,
    val id: String,
    val images: ArrayList<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: String,
    val modified: String,
    val pageCount: String,
    val prices: ArrayList<Price>,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val textObjects: ArrayList<TextObject>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val urls: ArrayList<Url>,
    val variantDescription: String,
    val variants: ArrayList<Variant>
)

data class Characters(
    val available: String,
    val collectionURI: String,
    val items: ArrayList<Item>,
    val returned: String
)

data class CollectedIssue(
    val name: String,
    val resourceURI: String
)

data class Collection(
    val name: String,
    val resourceURI: String
)

data class Creators(
    val available: String,
    val collectionURI: String,
    val items: ArrayList<ItemX>,
    val returned: String
)

data class Date(
    val date: String,
    val type: String
)

data class Events(
    val available: String,
    val collectionURI: String,
    val items: ArrayList<ItemXX>,
    val returned: String
)

data class Image(
    val extension: String,
    val path: String
)

data class Price(
    val price: String,
    val type: String
)

data class Series(
    val name: String,
    val resourceURI: String
)

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: ArrayList<ItemXXX>,
    val returned: String
)

data class TextObject(
    val language: String,
    val text: String,
    val type: String
)

data class Thumbnail(
    val extension: String,
    var path: String
)

data class Url(
    val type: String,
    val url: String
)

data class Variant(
    val name: String,
    val resourceURI: String
)

data class Item(
    val name: String,
    val resourceURI: String,
    val role: String
)

data class ItemX(
    val name: String,
    val resourceURI: String,
    val role: String
)

data class ItemXX(
    val name: String,
    val resourceURI: String
)

data class ItemXXX(
    val name: String,
    val resourceURI: String,
    val type: String
)

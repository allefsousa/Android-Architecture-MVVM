package com.developer.allef.mvvmbooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookBodyResponse (
    @Json(name = "results")
    val booksResults : List<BooksResultsResponse>
)
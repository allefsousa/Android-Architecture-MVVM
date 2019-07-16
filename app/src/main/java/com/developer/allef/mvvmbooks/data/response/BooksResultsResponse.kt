package com.developer.allef.mvvmbooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BooksResultsResponse (
    @Json(name = "book_details")
     val booksDetails:List<BookDetailsResponse>
)

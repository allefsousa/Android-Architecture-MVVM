package com.developer.allef.mvvmbooks.data

import com.developer.allef.mvvmbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun listBook(
        @Query("api-key") key:String = "c2U36nGLedfR6OR3CfkMHUYlsE7n6eRU",
        @Query("list") list:String = "hardcover-fiction"
    ):Call<BookBodyResponse>
}
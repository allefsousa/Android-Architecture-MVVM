package com.developer.allef.mvvmbooks.data.response

import android.accounts.AuthenticatorDescription
import android.support.v7.widget.DialogTitle
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BookDetailsResponse (
    val title: String,
    val author: String,
    val description: String
)

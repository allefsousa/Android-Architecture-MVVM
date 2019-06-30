package com.developer.allef.mvvmbooks.presentation.books

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.developer.allef.mvvmbooks.data.model.Book

class BooksViewModel : ViewModel() {
     val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        booksLiveData.value  = createFakeBooks()
    }

     fun createFakeBooks () :List<Book> {
        return  listOf(
            Book("Title 1 ","Autor 1"),
            Book("Title 2","Autor 2"))
    }




}
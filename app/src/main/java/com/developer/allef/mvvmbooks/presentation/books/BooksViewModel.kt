package com.developer.allef.mvvmbooks.presentation.books

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.developer.allef.mvvmbooks.data.ApiService
import com.developer.allef.mvvmbooks.data.model.Book
import com.developer.allef.mvvmbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Response

class BooksViewModel : ViewModel() {
     val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()
     val errorMessage : MutableLiveData<String> = MutableLiveData()
     val failureMessage : MutableLiveData<String> = MutableLiveData()

    fun getBooks(){
        ApiService.service.listBook().enqueue(object :retrofit2.Callback<BookBodyResponse>{
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                failureMessage.value = "Falha"
            }

            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if (response.isSuccessful){
                    val books: MutableList<Book> = mutableListOf()
                    response.body()?.let {
                        for (results in it.booksResults){
                            val book = Book(title = results.booksDetails[0].title,
                                autor = results.booksDetails[0].author
                                )
                            books.add(book)
                        }
                    }
                    booksLiveData.value = books
                }else{
                    errorMessage.value = "Erro"
                }
            }

        })
    }

     fun createFakeBooks () :List<Book> {
        return  listOf(
            Book("Title 1 ","Autor 1"),
            Book("Title 2","Autor 2"))
    }

}
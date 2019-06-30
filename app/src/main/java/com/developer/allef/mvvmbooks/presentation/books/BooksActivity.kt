package com.developer.allef.mvvmbooks.presentation.books

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.developer.allef.mvvmbooks.R
import com.developer.allef.mvvmbooks.data.model.book
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
        toolbarBooks.title = getString(R.string.books_toolbar_title)
        setSupportActionBar(toolbarBooks)
        with(recyclerBooks){
            layoutManager = LinearLayoutManager(this@BooksActivity,RecyclerView.VERTICAL,false)
            setHasFixedSize(true)
            adapter = BooksAdapter(getBooks())
        }
    }

    private fun getBooks () :List<book> {
        return  listOf<book>(book("Title 1 ","Autor 1"),
            book("Title 2","Autor 2"))
    }
}

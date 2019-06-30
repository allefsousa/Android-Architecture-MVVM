package com.developer.allef.mvvmbooks.presentation.books

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.developer.allef.mvvmbooks.R
import com.developer.allef.mvvmbooks.data.model.Book
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
        toolbarBooks.title = getString(R.string.books_toolbar_title)
        setSupportActionBar(toolbarBooks)


        val viewModel : BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, Observer {
            it?.let {books ->
                with(recyclerBooks){
                    layoutManager = LinearLayoutManager(this@BooksActivity,RecyclerView.VERTICAL,false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books)
                }
            }
        })
        viewModel.getBooks()



    }


}

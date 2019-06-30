package com.developer.allef.mvvmbooks.presentation.books

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developer.allef.mvvmbooks.R
import com.developer.allef.mvvmbooks.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter( private val booksList: List<Book>) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return BooksViewHolder(itemView)


    }

    override fun getItemCount(): Int  = booksList.size

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(booksList[position])
    }

    class BooksViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val title = view.booksTitle
        private val autor = view.booksAuthor

        fun bindView(Book: Book){
            title.text = Book.title
            autor.text = Book.autor
        }
    }
}
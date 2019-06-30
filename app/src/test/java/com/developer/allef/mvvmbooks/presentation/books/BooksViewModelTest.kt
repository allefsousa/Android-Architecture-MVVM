package com.developer.allef.mvvmbooks.presentation.books

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.developer.allef.mvvmbooks.data.model.Book
import io.mockk.every
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.any
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class BooksViewModelTest{
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var mainViewModel: BooksViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mainViewModel = BooksViewModel()
    }

    @Test
    fun fetchUserRepositories_positiveResponse() {

        val observer = mock(Observer::class.java) as Observer<List<Book>>
        this.mainViewModel.booksLiveData.observeForever(observer)
        // Invoke
        this.mainViewModel.getBooks()
        // Verify
        assertNotNull(this.mainViewModel.booksLiveData.value)
        Mockito.verify(observer).onChanged(createFakeBooks())
    }


    fun createFakeBooks () :List<Book> {
        return  listOf(
            Book("Title 1 ","Autor 1"),
            Book("Title 2","Autor 2"))
    }

}
package com.fathan.quotesapplicationsimple.utilities

import com.fathan.quotesapplicationsimple.data.FakeDatabase
import com.fathan.quotesapplicationsimple.data.QuoteRepository
import com.fathan.quotesapplicationsimple.ui.QuoteViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuoteViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }
}
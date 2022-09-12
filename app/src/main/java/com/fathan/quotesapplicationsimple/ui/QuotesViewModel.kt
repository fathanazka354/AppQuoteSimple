package com.fathan.quotesapplicationsimple.ui

import androidx.lifecycle.ViewModel
import com.fathan.quotesapplicationsimple.data.Quote
import com.fathan.quotesapplicationsimple.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository):ViewModel() {
    fun addQuote(quote: Quote){
        quoteRepository.addQuote(quote)
    }
    fun getQuotes()=quoteRepository.getQuotes()
}
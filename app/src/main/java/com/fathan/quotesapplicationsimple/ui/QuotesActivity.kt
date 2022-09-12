@file:Suppress("DEPRECATION")

package com.fathan.quotesapplicationsimple.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.fathan.quotesapplicationsimple.R
import com.fathan.quotesapplicationsimple.data.Quote
import com.fathan.quotesapplicationsimple.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this){quotes->
            val stringBuilder = StringBuilder()
            quotes.forEach{quote->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder
        }
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
package com.appian.rue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.appian.rue.managers.CardManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(CardManager(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickListeners()
    }

    private fun setClickListeners() {
        draw.setOnClickListener { presenter.onDrawClick() }
        shuffle.setOnClickListener { presenter.onShuffleClick() }
        reset.setOnClickListener { presenter.onResetClick() }
    }

    override fun setEmptyResult() {
        resultBottom.text = ""
        resultTop.text = ""
        resultCenter.text = getString(R.string.no_more_cards)
    }

    override fun setResult(result: String) {
        resultTop.text = result
        resultBottom.text = result
    }

    override fun setCenterResult(result: String) {
        resultCenter.text = result
    }
}

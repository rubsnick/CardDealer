package com.appian.rue

import com.appian.rue.managers.CardManager
import com.appian.rue.model.Card

class MainPresenter(private val cardManager: CardManager, private val view: MainView) {
    private var currentCard: Card? = null

    fun onDrawClick() {
        currentCard = cardManager.dealOneCard()
        if (currentCard != null) {
            view.setResult(currentCard!!.rank.value + currentCard!!.suit.value)
            view.setCenterResult(currentCard!!.rank.value)
        } else {
            view.setEmptyResult()
        }
    }

    fun onShuffleClick() {
        cardManager.shuffle()
    }

    fun onResetClick() {
        currentCard = null
        cardManager.initializeDeck()
        view.setResult("")
        view.setCenterResult("")
    }
}
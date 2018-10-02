package com.appian.rue.managers

import com.appian.rue.model.Card
import com.appian.rue.model.enums.Rank
import com.appian.rue.model.enums.Suit
import java.util.*

class CardManager {
    private lateinit var deck: Stack<Card>

    init {
        initializeDeck()
    }

     fun initializeDeck() {
         deck = Stack()
        for (suit in Suit.values()) {
            for (rank in Rank.values()) {
                deck.add(Card(suit, rank))
            }
        }
    }

    fun shuffle() {
        val temporaryDeck = Stack<Card>()
        for (i in 0 until deck.size) {
            val index = Random().nextInt(deck.size) // Each iteration is we evaluate the size and it decreases since we remove it at line 31
            temporaryDeck.add(deck[index])
            deck.removeAt(index)
        }
        deck = temporaryDeck
    }

    fun dealOneCard(): Card? {
        return if(deck.isNotEmpty()) deck.pop() else null
    }
}
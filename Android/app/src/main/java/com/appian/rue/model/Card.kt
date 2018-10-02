package com.appian.rue.model

import com.appian.rue.model.enums.Rank
import com.appian.rue.model.enums.Suit

data class Card(val suit: Suit,
                val rank: Rank)
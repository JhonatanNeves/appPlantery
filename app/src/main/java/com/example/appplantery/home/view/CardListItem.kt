package com.example.appplantery.home.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CardListItem(
    val id: Int,
    @StringRes val textHeadStringId: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val textDescStringId: Int
)

package com.example.appplantery.profile.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ListItem(
    val id: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val textStringId: Int,
    @DrawableRes val endBottonId: Int
)

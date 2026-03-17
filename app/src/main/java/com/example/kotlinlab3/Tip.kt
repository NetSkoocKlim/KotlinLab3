package com.example.kotlinlab3

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val dayNumber: Int,
    @param:StringRes val titleRes: Int,
    @param:StringRes val shortDescRes: Int,
    @param:StringRes val fullDescRes: Int,
    @param:DrawableRes val imageRes: Int
)
package com.example.kotlinlab3

import android.annotation.SuppressLint
import android.content.Context

object TipsDataSource {
    fun loadTips(context: Context): List<Tip> {
        val tips = mutableListOf<Tip>()

        for (i in 1..30) {
            val titleRes = context.resources.getIdentifier("tip_${i}_title", "string", context.packageName)
            val shortDescRes = context.resources.getIdentifier("tip_${i}_short", "string", context.packageName)
            val fullDescRes = context.resources.getIdentifier("tip_${i}_full", "string", context.packageName)

            val imageRes = context.resources.getIdentifier("tip_${i}_image", "drawable", context.packageName)
            if (titleRes != 0) {
                tips.add(Tip(i, titleRes, shortDescRes, fullDescRes, imageRes))
            }
        }
        return tips
    }
}
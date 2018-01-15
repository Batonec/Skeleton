package ru.batonec.skeleton.data

import android.content.Context
import android.support.annotation.StringRes

class ResourceManager(private val context: Context) {
    fun getString(@StringRes stringId: Int) = context.getString(stringId)
}
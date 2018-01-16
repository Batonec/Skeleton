package ru.batonec.skeleton.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpView

interface NavigationView : MvpView {
    fun navigateToScreen(key: String, args: Bundle? = null)
}
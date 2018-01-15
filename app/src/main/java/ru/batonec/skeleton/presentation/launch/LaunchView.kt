package ru.batonec.skeleton.presentation.launch

import com.arellomobile.mvp.MvpView

interface LaunchView : MvpView {
    fun showInfo(info: String)
    fun showError(error: String)
    fun showProgress()
    fun hideProgress()
}
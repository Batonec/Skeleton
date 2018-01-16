package ru.batonec.skeleton.presentation.main

import ru.batonec.skeleton.presentation.base.NavigationView

interface MainView: NavigationView {
    fun showProgress()
    fun hideProgress()
}
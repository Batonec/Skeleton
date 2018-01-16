package ru.batonec.skeleton.presentation.launch

interface LaunchView : ru.batonec.skeleton.presentation.base.NavigationView {
    fun showError(error: String)
    fun showProgress()
    fun hideProgress()
}
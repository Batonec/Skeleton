package ru.batonec.skeleton.di

import dagger.Component
import dagger.Subcomponent
import ru.batonec.skeleton.presentation.launch.LaunchPresenter
import ru.batonec.skeleton.presentation.main.MainPresenter
import ru.batonec.skeleton.ui.launch.LaunchActivity
import javax.inject.Singleton

/**
 * AppComponent - main application component. Contains context, utils etc
 * SessionComponent - have some lifecycle as logged user
 */

@Component(modules = [(AppModule::class)])
@Singleton
interface AppComponent {
    fun plus(module: SessionModule): SessionComponent
    fun plus(module: LaunchModule): LaunchComponent
}

@Subcomponent(modules = [(LaunchModule::class)])
@LaunchScope
interface LaunchComponent {
    fun launchPresenter(): LaunchPresenter
    fun inject(activity: LaunchActivity)
}

@Subcomponent(modules = [(SessionModule::class)])
@SessionScope
interface SessionComponent {
    fun plus(module: MainModule): MainComponent
}

@Subcomponent(modules = [(MainModule::class)])
@MainScope
interface MainComponent {
    fun mainPresenter(): MainPresenter
    fun inject(activity: MainPresenter)
}
package ru.batonec.skeleton

import android.app.Application
import ru.batonec.skeleton.di.DependencyManager
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppScope()
        initLogger()
    }

    private fun initAppScope() {
        DependencyManager.openAppComponent(this)
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
package ru.batonec.skeleton

import android.app.Application
import ru.batonec.skeleton.di.AppComponent
import ru.batonec.skeleton.di.AppModule
import ru.batonec.skeleton.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initAppScope()
        initLogger()
    }

    private fun initAppScope() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
package ru.batonec.skeleton.di

import android.content.Context
import java.util.*

object DependencyManager {
    private var appComponent: AppComponent? = null
    private var sessionComponent: SessionComponent? = null
    private var launchComponent: LaunchComponent? = null
    private var mainComponent: MainComponent? = null

    /**
     * assumed, that this method always called from App.onCreate, hence appComponent always will be nonNull
     * all other methods directly using appComponent
     */
    fun openAppComponent(appContext: Context): AppComponent {
        var component = appComponent
        if(component == null) {
            component = DaggerAppComponent.builder().appModule(AppModule(appContext)).build()!!
            appComponent = component
        }
        return component
    }

    /**
     * assumed that this method called when user logged in
     * when app process dies, and then was recreated, user maybe located in some activity stack
     * so, we should recreate dependency graph, but we not have saved sessionId (it should be saved internally in session repositories)
     * for handle this case, we call openSessionComponent with null parameter
     * in internals, sessionRepository logic should persist sessionId, and then check it
     * if session not exists, app logic handle this in other place, navigate user to login screen for example
     */
    fun openSessionComponent(session: UUID? = null): SessionComponent {
        var component = sessionComponent
        if(component == null) {
            component = appComponent!!.plus(SessionModule(session))
            sessionComponent = component
        }

        return component
    }

    fun closeSessionComponent() {
        sessionComponent = null
    }

    fun openLaunchComponent(): LaunchComponent {
        var component = launchComponent
        if(component == null) {
            component = appComponent!!.plus(LaunchModule())
            launchComponent = component
        }

        return component
    }

    fun closeLaunchComponent() {
        launchComponent = null
    }

    fun openMainComponent(): MainComponent {
        var component = mainComponent
        if (component == null) {
            component = openSessionComponent().plus(MainModule())
            mainComponent = component
        }

        return component
    }

    fun closeMainComponent() {
        mainComponent = null
    }
}
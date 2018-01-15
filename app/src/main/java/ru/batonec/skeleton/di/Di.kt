package ru.batonec.skeleton.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.batonec.skeleton.data.LaunchRepository
import ru.batonec.skeleton.data.ResourceManager
import ru.batonec.skeleton.presentation.launch.LaunchPresenter
import ru.batonec.skeleton.ui.launch.LaunchActivity
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {
    @Provides
    @Singleton
    fun context() = appContext

    @Provides
    @Singleton
    fun resourceManager() = ResourceManager(appContext)

    @Provides
    @Singleton
    fun launchIRepository() = LaunchRepository()
}

@Component(modules = [(AppModule::class)])
@Singleton
interface AppComponent {
    fun getContext(): Context
    fun launchPresenter(): LaunchPresenter
    fun inject(activity: LaunchActivity)
}
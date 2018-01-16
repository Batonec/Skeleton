package ru.batonec.skeleton.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.batonec.skeleton.data.ResourceManager
import ru.batonec.skeleton.data.SessionRepository
import ru.batonec.skeleton.data.launch.LaunchRepository
import ru.batonec.skeleton.data.main.MainRepository
import java.util.*
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {
    @Provides
    @Singleton
    fun context() = appContext

    @Provides
    @Singleton
    fun resourceManager() = ResourceManager(appContext)
}

/**
 * user session can be null if app process recreated.
 * See {@link ru.batonec.skeleton.DependencyManager.openSessionComponent label}
 */
@Module
class SessionModule(private val userSession: UUID? = null) {
    @Provides
    @SessionScope
    fun sessionRepository(): SessionRepository {
        val repository = SessionRepository()
        userSession?.let { repository.saveSession(it) }
        return repository
    }
}

@Module
class LaunchModule {
    @Provides
    @LaunchScope
    fun launchRepository() = LaunchRepository()
}

@Module
class MainModule {
    @Provides
    @MainScope
    fun mainRepository(sessionRepository: SessionRepository) = MainRepository(sessionRepository)
}
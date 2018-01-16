package ru.batonec.skeleton.presentation.main

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.batonec.skeleton.ScreenKeys
import ru.batonec.skeleton.di.DependencyManager
import ru.batonec.skeleton.domain.main.MainInteractor
import ru.batonec.skeleton.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val interactor: MainInteractor
) : BasePresenter<MainView>() {

    fun performTask() {
        interactor.apiRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showProgress() }
                .doOnTerminate { viewState.hideProgress() }
                .subscribe()
                .connect()
    }

    fun logout() {
        interactor.logout().subscribeOn(Schedulers.io()).subscribe().connect()
        DependencyManager.closeSessionComponent()
        viewState.navigateToScreen(ScreenKeys.LaunchScreen)
    }
}
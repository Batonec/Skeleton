package ru.batonec.skeleton.presentation.launch

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.batonec.skeleton.R
import ru.batonec.skeleton.data.ResourceManager
import ru.batonec.skeleton.domain.launch.LaunchInteractor
import ru.batonec.skeleton.presentation.base.BasePresenter
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class LaunchPresenter @Inject constructor(
        private val resourceManager: ResourceManager,
        private val interactor: LaunchInteractor
) : BasePresenter<LaunchView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showInfo(resourceManager.getString(R.string.app_name))
    }

    fun performLongTask() {
        interactor.getInfo().delay(300, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showProgress() }
                .doAfterTerminate { viewState.hideProgress() }
                .subscribe(
                        { viewState.showInfo(it) },
                        { viewState.showError(it.toString()); Timber.e(it) }
                )
                .connect()
    }
}
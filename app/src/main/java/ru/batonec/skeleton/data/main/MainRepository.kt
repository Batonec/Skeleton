package ru.batonec.skeleton.data.main

import io.reactivex.Completable
import ru.batonec.skeleton.data.SessionRepository
import timber.log.Timber
import javax.inject.Inject

class MainRepository @Inject constructor(private val sessionRepository: SessionRepository) {
    fun apiRequest(): Completable = Completable.fromCallable {
        Thread.sleep(1000)
        Timber.d("api request for ${sessionRepository.session}")
    }
}
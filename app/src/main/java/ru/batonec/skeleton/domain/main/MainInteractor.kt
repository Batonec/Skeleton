package ru.batonec.skeleton.domain.main

import ru.batonec.skeleton.data.SessionRepository
import ru.batonec.skeleton.data.main.MainRepository
import javax.inject.Inject

class MainInteractor @Inject constructor(
        private val mainRepository: MainRepository,
        private val sessionRepository: SessionRepository
) {
    fun apiRequest() = mainRepository.apiRequest()

    fun logout() = sessionRepository.clearSession()
}
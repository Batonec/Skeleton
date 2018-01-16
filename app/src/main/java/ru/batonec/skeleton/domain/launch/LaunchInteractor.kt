package ru.batonec.skeleton.domain.launch

import ru.batonec.skeleton.data.launch.LaunchRepository
import java.util.*
import javax.inject.Inject

class LaunchInteractor @Inject constructor(
        private val launchRepository: LaunchRepository
) {
    fun getInfo() = launchRepository.getInfo(UUID.randomUUID())
}
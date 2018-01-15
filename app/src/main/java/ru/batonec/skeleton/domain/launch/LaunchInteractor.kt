package ru.batonec.skeleton.domain.launch

import ru.batonec.skeleton.data.LaunchRepository
import javax.inject.Inject

class LaunchInteractor @Inject constructor(private val repository: LaunchRepository) {
    fun getInfo() = repository.getInfo()
}
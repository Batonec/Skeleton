package ru.batonec.skeleton.data.launch

import io.reactivex.Single
import java.util.*

class LaunchRepository {
    fun getInfo(session: UUID): Single<UUID> = Single.fromCallable { session }
}
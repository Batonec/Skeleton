package ru.batonec.skeleton.data

import io.reactivex.Single
import java.util.*
import kotlin.math.absoluteValue

class LaunchRepository {
    fun getInfo(): Single<String> = Single.fromCallable { "test ${Random().nextInt().absoluteValue}" }
}
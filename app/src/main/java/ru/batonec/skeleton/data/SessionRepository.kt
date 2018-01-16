package ru.batonec.skeleton.data

import io.reactivex.Completable
import java.util.*

class SessionRepository {
    var session: UUID? = null
        private set(value) {
            field = value
        }

    fun saveSession(session: UUID) {
        this.session = session
    }

    fun clearSession(): Completable = Completable.fromAction {
        this.session = null
    }
}
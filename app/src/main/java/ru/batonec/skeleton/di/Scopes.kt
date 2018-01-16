package ru.batonec.skeleton.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SessionScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class LaunchScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScope
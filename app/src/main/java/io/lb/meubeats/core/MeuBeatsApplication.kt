package io.lb.meubeats.core

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.lb.meubeats.BuildConfig
import io.lb.meubeats.di.DaggerAppComponent
import timber.log.Timber

class MeuBeatsApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        return DaggerAppComponent.builder().application(this).build()
    }
}
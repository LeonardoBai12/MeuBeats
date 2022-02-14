package io.lb.meubeats.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.lb.meubeats.di.headset.HeadsetModule
import io.lb.meubeats.di.headset.HeadsetViewModelModule
import io.lb.meubeats.ui.headset.HeadsetDetailsActivity
import io.lb.meubeats.ui.login.LoginActivity
import io.lb.meubeats.ui.main.MainActivity
import io.lb.meubeats.ui.splash.SplashActivity

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector(
        modules = [
            HeadsetModule::class,
            HeadsetViewModelModule::class,
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeHeadsetActivity(): HeadsetDetailsActivity
}
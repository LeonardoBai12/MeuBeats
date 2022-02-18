package io.lb.meubeats.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.lb.meubeats.headset_feature.di.HeadsetDetailsViewModelModule
import io.lb.meubeats.headset_feature.di.HeadsetModule
import io.lb.meubeats.headset_feature.di.HeadsetViewModelModule
import io.lb.meubeats.headset_feature.presentation.headset.HeadsetActivity
import io.lb.meubeats.headset_feature.presentation.headset_details.HeadsetDetailsActivity
import io.lb.meubeats.user_feature.di.UserModule
import io.lb.meubeats.user_feature.di.UserViewModelModule
import io.lb.meubeats.not_connected_feature.presentation.NotConnectedActivity
import io.lb.meubeats.splash_feature.presentation.SplashActivity
import io.lb.meubeats.user_feature.presentation.login.LoginActivity

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeNotConnectedActivity(): NotConnectedActivity

    @ContributesAndroidInjector(
        modules = [
            UserModule::class,
            UserViewModelModule::class,
        ]
    )
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector(
        modules = [
            HeadsetModule::class,
            HeadsetViewModelModule::class,
        ]
    )
    abstract fun contributeHeadsetActivity(): HeadsetActivity

    @ContributesAndroidInjector(
        modules = [
            HeadsetModule::class,
            HeadsetDetailsViewModelModule::class,
        ]
    )
    abstract fun contributeHeadsetDetailsActivity(): HeadsetDetailsActivity
}
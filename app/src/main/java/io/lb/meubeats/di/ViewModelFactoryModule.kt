package io.lb.meubeats.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.lb.meubeats.core.ViewModelProviderFactory

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(
        providerFactory : ViewModelProviderFactory
    ) : ViewModelProvider.Factory
}
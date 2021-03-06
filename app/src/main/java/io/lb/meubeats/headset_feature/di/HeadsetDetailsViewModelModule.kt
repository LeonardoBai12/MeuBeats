package io.lb.meubeats.headset_feature.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.lb.meubeats.di.ViewModelKey
import io.lb.meubeats.headset_feature.presentation.headset_details.HeadsetDetailsViewModel

@Module
abstract class HeadsetDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HeadsetDetailsViewModel::class)
    abstract fun bindHeadsetDetailsViewModel(viewModel: HeadsetDetailsViewModel) : ViewModel
}
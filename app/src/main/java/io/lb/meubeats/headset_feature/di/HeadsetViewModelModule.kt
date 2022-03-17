package io.lb.meubeats.headset_feature.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.lb.meubeats.di.ViewModelKey
import io.lb.meubeats.headset_feature.presentation.headset.HeadsetListViewModel

@Module
abstract class HeadsetViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HeadsetListViewModel::class)
    abstract fun bindHeadsetViewModel(viewModel: HeadsetListViewModel) : ViewModel
}
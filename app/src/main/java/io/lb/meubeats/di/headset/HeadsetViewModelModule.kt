package io.lb.meubeats.di.headset

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.lb.meubeats.di.ViewModelKey
import io.lb.meubeats.ui.headset.HeadsetViewModel

@Module
abstract class HeadsetViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HeadsetViewModel::class)
    abstract fun bindHeadsetViewModel(viewModel: HeadsetViewModel) : ViewModel
}
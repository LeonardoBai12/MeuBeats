package io.lb.meubeats.di.user

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.lb.meubeats.di.ViewModelKey
import io.lb.meubeats.headset_feature.presentation.login.UserViewModel

@Module
abstract class UserViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(viewModel: UserViewModel) : ViewModel
}
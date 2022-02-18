package io.lb.meubeats.user_feature.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.lb.meubeats.di.ViewModelKey
import io.lb.meubeats.user_feature.presentation.login.LoginViewModel

@Module
abstract class UserViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindUserViewModel(viewModel: LoginViewModel) : ViewModel
}
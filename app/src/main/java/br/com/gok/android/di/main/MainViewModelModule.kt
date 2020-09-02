package br.com.gok.android.di.main

import br.com.gok.android.repository.remote.api.DigioRepositoryImpl
import br.com.gok.android.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModel {
        MainViewModel(repository = get())
    }
    single { DigioRepositoryImpl(get(), androidContext()) }
}
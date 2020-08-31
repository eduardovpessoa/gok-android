package br.com.gok.android.di

import br.com.gok.android.repository.remote.api.DigioRepositoryImpl
import br.com.gok.android.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {

    val instance = module {
        viewModel { MainViewModel(repository = get()) }
        single { DigioRepositoryImpl(api = get()) }
    }
}
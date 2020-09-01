package br.com.gok.android.di.main

import br.com.gok.android.repository.remote.api.DigioAPI
import br.com.gok.android.repository.remote.api.DigioRepositoryImpl
import br.com.gok.android.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object MainModule {
    val mainInstance = module {
        fun provideDigioAPI(retrofit: Retrofit): DigioAPI {
            return retrofit.create(DigioAPI::class.java)
        }
        single { provideDigioAPI(get()) }
        viewModel { MainViewModel(repository = get()) }
        single { DigioRepositoryImpl(api = get(), context = androidContext()) }
    }
}
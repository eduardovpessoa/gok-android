package br.com.gok.android.di.main

import android.content.Context
import br.com.gok.android.repository.remote.api.DigioAPI
import br.com.gok.android.repository.remote.api.DigioRepository
import br.com.gok.android.repository.remote.api.DigioRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val mainRepositoryModule = module {
    fun provideDigioRepository(api: DigioAPI, context: Context): DigioRepository {
        return DigioRepositoryImpl(api, context)
    }
    single { provideDigioRepository(get(), androidContext()) }
}
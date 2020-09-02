package br.com.gok.android.di.main

import br.com.gok.android.repository.remote.api.DigioAPI
import org.koin.dsl.module
import retrofit2.Retrofit

val mainApiModule = module {
    fun provideDigioAPI(retrofit: Retrofit): DigioAPI {
        return retrofit.create(DigioAPI::class.java)
    }
    single { provideDigioAPI(get()) }
}
package br.com.gok.android

import android.app.Application
import br.com.gok.android.di.main.mainApiModule
import br.com.gok.android.di.main.mainRepositoryModule
import br.com.gok.android.di.main.mainViewModelModule
import br.com.gok.android.di.main.mainNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    mainApiModule,
                    mainViewModelModule,
                    mainRepositoryModule,
                    mainNetworkModule
                )
            )
        }
    }
}
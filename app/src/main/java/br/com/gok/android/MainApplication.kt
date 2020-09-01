package br.com.gok.android

import android.app.Application
import br.com.gok.android.di.main.MainModule
import br.com.gok.android.di.main.MainNetworkModule
import br.com.gok.android.di.main.mainViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(
                MainModule.mainInstance,
                mainViewModelModule,
                MainNetworkModule.networkInstance
            )
        }
    }
}
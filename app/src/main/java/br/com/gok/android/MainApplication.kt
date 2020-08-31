package br.com.gok.android

import android.app.Application
import br.com.gok.android.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(MainModule.instance))
        }
    }
}
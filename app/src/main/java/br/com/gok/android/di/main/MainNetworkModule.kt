package br.com.gok.android.di.main

import br.com.gok.android.repository.remote.util.Constants
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MainNetworkModule {

    private const val connectTimeout: Long = 15
    private const val readTimeout: Long = 20

    val networkInstance = module {

        fun provideHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .build()
        }

        fun provideRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
        }

        single { provideHttpClient() }
        single { provideRetrofit(get(), Constants.PATH) }
    }
}
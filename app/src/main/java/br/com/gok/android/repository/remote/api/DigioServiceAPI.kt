package br.com.gok.android.repository.remote.api

import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.util.Constants.PATH
import br.com.gok.android.repository.remote.util.Constants.CONTEXT
import br.com.gok.android.repository.remote.util.Constants.PRODUCTS
import br.com.gok.android.repository.remote.model.dto.ProductsDTO
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

abstract class DigioServiceAPI {

    private val connectTimeout: Long = 15
    private val readTimeout: Long = 20

    fun getServiceAPI(): DigioServiceAPI {
        val httpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("$PATH$CONTEXT")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(DigioServiceAPI::class.java)
    }

    @GET(PRODUCTS)
    abstract suspend fun fetchProducts(): BaseResult<ProductsDTO>
}
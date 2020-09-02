package br.com.gok.android.main

import android.content.Context
import br.com.gok.android.main.mocks.FakeProducts
import br.com.gok.android.repository.DigioAPI
import br.com.gok.android.repository.DigioRepositoryImpl
import br.com.gok.android.repository.remote.util.NetworkUtils.handleSuccess
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class MainRepositoryTest {

    private val api = mockk<DigioAPI>()
    private val context = mockk<Context>(relaxed = true)
    private val repository = DigioRepositoryImpl(api, context)

    @Before
    fun setup() {
        clearAllMocks()
    }

    @Test
    fun `test should return success when fetchProducts`() {
        every { api.fetchProducts() } returns Response.success(FakeProducts.response())
        val response = repository.fetchProducts()
        val success = handleSuccess(api.fetchProducts())
        Assert.assertEquals(response, success)
    }

    @Test
    fun `test should not return success when fetchProducts`() {
        every { api.fetchProducts() } returns Response.error(
            500, ResponseBody.create(
                MediaType.parse("application/json"),
                "{\"errors\":[{\"code\": 500, \"message\": \"errorMsg\"}]}"
            )
        )
        val response = repository.fetchProducts()
        Assert.assertNotEquals(response, FakeProducts.response())
    }
}
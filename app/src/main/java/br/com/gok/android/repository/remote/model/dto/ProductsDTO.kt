package br.com.gok.android.repository.remote.model.dto

import android.os.Parcelable
import br.com.gok.android.repository.remote.model.Cash
import br.com.gok.android.repository.remote.model.Product
import br.com.gok.android.repository.remote.model.Spotlight
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductsDTO(
    @SerializedName("spotlight")
    val spotlights: List<Spotlight>,
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("cash")
    val cash: Cash
) : Parcelable
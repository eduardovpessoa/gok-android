package br.com.gok.android.repository.remote.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cash(
    @SerializedName("title")
    val title: String,
    @SerializedName("bannerURL")
    val bannerURL: String,
    @SerializedName("description")
    val description: String
) : Parcelable {
    companion object {
        @BindingAdapter("imageURL")
        @JvmStatic
        fun loadImage(view: ImageView, prodImg: String) {
            Glide.with(view.context)
                .load(prodImg)
                .centerCrop()
                .into(view)
        }
    }
}
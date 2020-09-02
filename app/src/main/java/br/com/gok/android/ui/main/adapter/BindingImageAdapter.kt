package br.com.gok.android.ui.main.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.gok.android.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

object BindingImageAdapter {

    @JvmStatic
    @BindingAdapter(value = ["src"], requireAll = false)
    fun loadImage(imageView: ImageView, src: String?) {
        if (src != null) {
            Glide.with(imageView.context)
                .load(src)
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_no_image)
                .into(imageView)
        }
    }
}
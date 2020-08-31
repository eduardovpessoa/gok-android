package br.com.gok.android.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.gok.android.R
import br.com.gok.android.repository.remote.model.Spotlight
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_adapter_spotlights.view.imgBanner

class MainSpotlightAdapter(private val context: Context) :
    RecyclerView.Adapter<MainSpotlightAdapter.ViewItemHolder>() {

    var spotlights: List<Spotlight> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {
        val viewBinding: MainSpotlightRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.main_adapter_spotlights, parent, false
        )
        return ViewItemHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return spotlights.size
    }

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {
        val item = spotlights[position]
        Glide.with(context).load(item.imageURL).into(holder.image)
        holder.image.setOnClickListener {
            Toast.makeText(
                context,
                String.format("Name: %s\nDescription: %s", item.name, item.description),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    inner class ViewItemHolder(private val viewBinding: MainSpotlightRowBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun onBind() {
            val row = spotlights[adapterPosition]
            viewBinding.products = row
        }
    }
}
package br.com.gok.android.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.gok.android.R
import br.com.gok.android.databinding.MainAdapterSpotlightsBinding
import br.com.gok.android.repository.remote.model.Spotlight
import com.bumptech.glide.Glide

class MainSpotlightAdapter(private val context: Context) :
    RecyclerView.Adapter<MainSpotlightAdapter.ViewItemHolder>() {

    var spotlights: List<Spotlight> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {
        val viewBinding: MainAdapterSpotlightsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.main_adapter_spotlights, parent, false
        )
        return ViewItemHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return spotlights.size
    }

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {
        holder.onBind(position)
    }

    fun setSpotlightsData(spotlights : List<Spotlight>) {
        this.spotlights = spotlights
        notifyDataSetChanged()
    }

    inner class ViewItemHolder(private val viewBinding: MainAdapterSpotlightsBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(position: Int) {
            val row = spotlights[position]
            viewBinding.spotlights = row
            Glide.with(context).load(spotlights[position].imageURL)
                .into(itemView.findViewById(R.id.imgBanner))
        }
    }
}
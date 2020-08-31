package br.com.gok.android.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.gok.android.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_adapter_products.view.imgProduct

class MainProductAdapter(private val context: Context) :
    RecyclerView.Adapter<MainProductAdapter.ViewItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {
        val viewBinding: View =
            LayoutInflater.from(context).inflate(R.layout.main_adapter_products, parent, false)
        return ViewItemHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.imgProduct
    }

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {
        val prod = products[position]
        Glide.with(context).load(prod.imageURL).into(holder.image)
        holder.image.setOnClickListener {
            Toast.makeText(
                context,
                String.format("Name: %s\nDescription: %s", prod.name, prod.description),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
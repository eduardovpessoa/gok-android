package br.com.gok.android.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.gok.android.R
import br.com.gok.android.databinding.MainAdapterProductsBinding
import br.com.gok.android.repository.remote.model.Product

class MainProductAdapter :
    RecyclerView.Adapter<MainProductAdapter.ViewItemHolder>() {

    var products: List<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {
        val viewBinding: MainAdapterProductsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.main_adapter_products, parent, false
        )
        return ViewItemHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {
        holder.onBind(position)
    }

    fun setProductsData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    inner class ViewItemHolder(private val viewBinding: MainAdapterProductsBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(position: Int) {
            val row = products[position]
            viewBinding.products = row
        }
    }
}
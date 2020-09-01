package br.com.gok.android.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.gok.android.R
import br.com.gok.android.databinding.MainFragmentBinding
import br.com.gok.android.ui.main.adapter.MainProductAdapter
import br.com.gok.android.ui.main.adapter.MainSpotlightAdapter
import com.bumptech.glide.Glide
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_fragment.imgCash
import kotlinx.android.synthetic.main.main_fragment.recyclerProduct
import kotlinx.android.synthetic.main.main_fragment.recyclerSpotlight
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val productsViewModel : MainViewModel by viewModel()
    private lateinit var productsAdapter: MainProductAdapter
    private lateinit var spotlightAdapter: MainSpotlightAdapter
    private lateinit var mDataBinding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        val rootView = mDataBinding.root
        mDataBinding.viewModel = productsViewModel
        mDataBinding.lifecycleOwner = this
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupSpotlightsAdapter()
        setupProductsAdapter()
        productsViewModel.getProducts()
        productsViewModel.products.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                spotlightAdapter.setSpotlightsData(it.spotlights)
                productsAdapter.setProductsData(it.products)
                Glide.with(this).load(it.cash.bannerURL).into(imgCash)
            }
        })
    }

    private fun setupSpotlightsAdapter() {
        spotlightAdapter = MainSpotlightAdapter(requireContext())
        recyclerSpotlight.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerSpotlight.adapter = spotlightAdapter
    }

    private fun setupProductsAdapter() {
        productsAdapter = MainProductAdapter(requireContext())
        recyclerProduct.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerProduct.adapter = productsAdapter
    }
}
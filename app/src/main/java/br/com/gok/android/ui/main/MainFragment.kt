package br.com.gok.android.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.gok.android.R
import br.com.gok.android.databinding.MainFragmentBinding
import br.com.gok.android.ui.main.adapter.MainProductAdapter
import br.com.gok.android.ui.main.adapter.MainSpotlightAdapter
import kotlinx.android.synthetic.main.main_fragment.recyclerProduct
import kotlinx.android.synthetic.main.main_fragment.recyclerSpotlight
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val productsViewModel by viewModel<MainViewModel>()
    private lateinit var productsAdapter: MainProductAdapter
    private lateinit var spotlightAdapter: MainSpotlightAdapter
    private lateinit var dataBinding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        val rootView = dataBinding.root
        dataBinding.lifecycleOwner = this
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupSpotlightsAdapter()
        setupProductsAdapter()
        dataBinding.viewModel = productsViewModel
        productsViewModel.getProducts()
        productsViewModel.products.observe(viewLifecycleOwner, Observer {
            if (it!=null){
              spotlightAdapter.setItems(it.spotlights)
              productsAdapter.setItems(it.products)
            }
        })
    }

    private fun setupSpotlightsAdapter(){
        spotlightAdapter = MainSpotlightAdapter(requireContext())
        recyclerSpotlight.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerSpotlight.adapter = spotlightAdapter
    }

    private fun setupProductsAdapter(){
        productsAdapter = MainProductAdapter(requireContext())
        recyclerProduct.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerProduct.adapter = productsAdapter
    }
}
package com.test.search.tickets.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.common.network.NetworkStatus
import com.test.core.adapterDelegate.AppAdapter
import com.test.search.R
import com.test.search.databinding.FragmentTicketsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketsFragment : Fragment(R.layout.fragment_tickets) {

    private val binding by viewBinding<FragmentTicketsBinding>()

    private val viewModel by viewModel<TicketsViewModel>()

    private val adapter by lazy {
        AppAdapter.Builder()
            .add(TicketsAdapterDelegate())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adaptersSetUp()
        viewModel.getTickets()
        setData()
        observeTickets()
        binding.arrowBackBtn.setOnClickListener {
            viewModel.navigateBack()
        }
    }

    private fun adaptersSetUp(){
        binding.flightsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.flightsRv.adapter = adapter
    }

    private fun observeTickets(){
        viewModel.ticketsResponse.observe(viewLifecycleOwner, Observer{ status ->
            when(status){
                is NetworkStatus.Success -> adapter.submitList(status.data)
                is NetworkStatus.Error -> Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
                is NetworkStatus.Loading -> {}
                else -> {}
            }
        })
    }

    private fun setData(){
        val data = viewModel.getFlightInfo()
        binding.flightDirectionTxt.text = "${data.flightFrom} -  ${data.flightTo}"
    }

}
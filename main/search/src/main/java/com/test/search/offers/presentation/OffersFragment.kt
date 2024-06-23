package com.test.search.offers.presentation

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.common.network.NetworkStatus
import com.test.common.utils.KeyBoardFilter
import com.test.core.adapterDelegate.AppAdapter
import com.test.search.R
import com.test.search.offers.presentation.uimodel.Destinations
import com.test.search.databinding.FragmentOffersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class OffersFragment : Fragment(R.layout.fragment_offers) {

    private val binding by viewBinding<FragmentOffersBinding>()

    private val viewModel by viewModel<OffersViewModel>()

    private val filter by lazy {
        KeyBoardFilter()
    }

    private val adapter by lazy {
        AppAdapter.Builder()
            .add(TicketOffersAdapterDelegate())
            .build()
    }

    lateinit var destinations: Destinations

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adaptersSetUp()
        viewModel.getTickets()
        observeTickets()

        binding.fromEditTxt.filters = arrayOf(filter)
        binding.toEditTxt.filters = arrayOf(filter)

        destinations = viewModel.getDestinations()
        binding.fromEditTxt.setText(destinations.start)
        binding.toEditTxt.setText(destinations.destination)
        clickListeners()
    }

    private fun observeTickets(){
        viewModel.ticketsResponse.observe(viewLifecycleOwner, Observer{ status ->
            when(status){
                is NetworkStatus.Success -> adapter.submitList(status.data.subList(0,3))
                is NetworkStatus.Error -> Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
                else -> {}
            }
        })
    }

    private fun clickListeners(){
        binding.replaceBtn.setOnClickListener {
            if(binding.fromEditTxt.text.toString() == destinations.start
                && binding.toEditTxt.text.toString() == destinations.destination){
                binding.fromEditTxt.setText(destinations.destination)
                binding.toEditTxt.setText(destinations.start)
            }else{
                binding.fromEditTxt.setText(destinations.start)
                binding.toEditTxt.setText(destinations.destination)
            }
        }
        binding.allTicketsBtn.setOnClickListener {
            try {
                viewModel.saveFlightDate(binding.tab.flightDateTxt.toString())
                viewModel.nextFragment()
            }catch (e: Exception){
                Log.e("nav", e.message ?: "Something")
            }
        }
        binding.tab.turnBackDateBtn.setOnClickListener {
            openDatePickerDialog(1)
        }
        binding.tab.flightDateBtn.setOnClickListener {
            openDatePickerDialog(2)
        }
        binding.goBackBtn.setOnClickListener {
            viewModel.navigateBack()
        }
    }

    private fun adaptersSetUp(){
        binding.ticketsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.ticketsRv.adapter = adapter
    }

    private fun openDatePickerDialog(type: Int) {
        // Get current date to set as default in the dialog
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        // Create a DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)
                val formattedDate = formatRussianDate(selectedDate.time)
                if (type == 1){
                    binding.tab.turnBackDateTxt.text = formattedDate
                    binding.tab.addIc.isVisible = false
                }else{
                    binding.tab.flightDateTxt.text = formattedDate
                }
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun formatRussianDate(date: Date): String {
        val dateFormat = SimpleDateFormat("d MMM, E", Locale("ru"))
        return dateFormat.format(date).replace(".", "")
    }

}
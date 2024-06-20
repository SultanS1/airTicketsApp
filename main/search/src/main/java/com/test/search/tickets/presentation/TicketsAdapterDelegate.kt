package com.test.search.tickets.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.test.core.adapterDelegate.DelegateAdapter
import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.search.databinding.FlightsItemBinding
import com.test.search.tickets.presentation.uimodel.Ticket

class TicketsAdapterDelegate : DelegateAdapter<Ticket, TicketsAdapterDelegate.TicketViewHolder>(Ticket::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = FlightsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Ticket,
        viewHolder: TicketViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class TicketViewHolder(private val binding: FlightsItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: Ticket) {
            binding.priceTxt.text = ticket.price
            binding.departureTimeTxt.text = ticket.ddate
            binding.departingFromTxt.text = ticket.dairport
            binding.arrivalTimeTxt.text = ticket.adate
            binding.arrivingToTxt.text = ticket.aairport

            val layoutParams = binding.container.layoutParams as ViewGroup.MarginLayoutParams
            if (ticket.badge == null){
                binding.statusContainer.visibility = View.GONE
            }else{
                binding.statusContainer.visibility = View.VISIBLE
                binding.badgeTxt.text = ticket.badge
            }
            if(!ticket.has_transfer){
                binding.flightInfoTxt.text = "${ticket.flightDuration} в пути / Без пересадок"
            }else{
                binding.flightInfoTxt.text = "${ticket.flightDuration} в пути"
            }
        }
    }
}
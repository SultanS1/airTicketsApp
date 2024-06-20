package com.test.search.offers.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.common.R
import com.test.core.adapterDelegate.DelegateAdapter
import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.search.offers.presentation.uimodel.TicketOffer
import com.test.search.databinding.AirlinesItemBinding

class TicketOffersAdapterDelegate : DelegateAdapter<TicketOffer, TicketOffersAdapterDelegate.TicketOfferViewHolder>(TicketOffer::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = AirlinesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketOfferViewHolder(binding)
    }

    override fun bindViewHolder(
        model: TicketOffer,
        viewHolder: TicketOfferViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class TicketOfferViewHolder(private val binding: AirlinesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: TicketOffer) {
            when(ticket.id){
                2 -> binding.image.setImageResource(R.drawable.flight_2)
                3 -> binding.image.setImageResource(R.drawable.flight_3)
            }
            binding.airlineNameTxt.text = ticket.title
            binding.timeTxt.text = ticket.timeRange
            binding.priceTxt.text = ticket.price
        }
    }
}
package com.test.main.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.core.adapterDelegate.DelegateAdapter
import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.main.databinding.OfferItemBinding
import com.test.main.presentation.uimodel.Offer

class OfferAdapterDelegate : DelegateAdapter<Offer, OfferAdapterDelegate.OfferViewHolder>(Offer::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = OfferItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Offer,
        viewHolder: OfferViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class OfferViewHolder(private val binding: OfferItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(offer: Offer) {
            Glide.with(binding.image).load(offer.image).into(binding.image)
            binding.cityTxt.text = offer.town
            binding.priceTxt.text = offer.price
            binding.titleTxt.text = offer.title
        }
    }
}
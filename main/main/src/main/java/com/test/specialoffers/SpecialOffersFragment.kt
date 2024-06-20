package com.test.specialoffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.main.R
import com.test.main.databinding.FragmentSpecialOffersBinding

class SpecialOffersFragment : Fragment(R.layout.fragment_special_offers) {

    private val binding by viewBinding<FragmentSpecialOffersBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
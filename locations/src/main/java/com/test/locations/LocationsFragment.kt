package com.test.locations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.locations.databinding.FragmentLocationsBinding

class LocationsFragment : Fragment(R.layout.fragment_locations) {

    private val binding by viewBinding<FragmentLocationsBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
package com.test.hotels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.hotels.databinding.FragmentHotelsBinding

class HotelsFragment : Fragment(R.layout.fragment_hotels) {

    private val binding by viewBinding<FragmentHotelsBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
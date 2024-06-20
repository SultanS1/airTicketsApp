package com.test.route

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.main.R
import com.test.main.databinding.FragmentRouteBinding

class RouteFragment : Fragment(R.layout.fragment_route) {

    private val binding by viewBinding<FragmentRouteBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
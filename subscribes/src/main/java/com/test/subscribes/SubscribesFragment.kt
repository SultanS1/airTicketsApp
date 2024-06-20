package com.test.subscribes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.subscribes.databinding.FragmentSubscribesBinding

class SubscribesFragment : Fragment(R.layout.fragment_subscribes) {

    private val binding by viewBinding<FragmentSubscribesBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
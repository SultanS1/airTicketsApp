package com.test.vacations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.main.R
import com.test.main.databinding.FragmentVacationsBinding

class VacationsFragment : Fragment(R.layout.fragment_vacations) {

    private val binding by viewBinding<FragmentVacationsBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
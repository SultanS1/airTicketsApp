package com.test.main.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.test.common.network.NetworkStatus
import com.test.common.utils.KeyBoardFilter
import com.test.core.adapterDelegate.AppAdapter
import com.test.main.R
import com.test.main.databinding.BottomSheetItemBinding
import com.test.main.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding<FragmentMainBinding>()

    private val viewModel by viewModel<MainViewModel>()

    private val filter = KeyBoardFilter()

    private val adapter by lazy {
        AppAdapter.Builder()
            .add(OfferAdapterDelegate())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fromEditTxt.filters = arrayOf(filter)
        binding.toEditTxt.filters = arrayOf(filter)

        binding.fromEditTxt.setText(viewModel.getLastDestination())

        adapterSetUp()

        viewModel.getOffers()
        observeOffers()

        fragmentListeners()

    }

    private fun showModalScreen(){

        val dialog = BottomSheetDialog(requireContext())

        val view = BottomSheetItemBinding.inflate(layoutInflater)

        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        view.fromEditTxt.setText(binding.fromEditTxt.text)

        view.clearBtn.setOnClickListener {
            view.toEditTxt.setText("")
        }

        view.fromEditTxt.filters = arrayOf(filter)
        view.toEditTxt.filters = arrayOf(filter)

        val city1 = view.city1
        val city2 = view.city2
        val city3 = view.city3
        city2.cityTxt.text = "Сочи"
        city3.cityTxt.text = "Пхукет"
        Glide.with(city2.cityImage).load("https://s3-alpha-sig.figma.com/img/3d6c/62d5/73c5359a03e09e5ce846ec58bbce7786?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=pDCHSjhPC5KZhqGhZjwUIEowaw5qOi8n7R4T4CZ~0o1qU1vUUIGhjgHKv0HW21XPU3OD5pYZxzIcYFHyazd60JKFlpDBrssUAsLoNLWGRqNXOyy6tkx4Vp-7GA8BVvusXOUyUV7rNr4vJulV0NEO32TQqZRqnXwieHT5ie1f4iciPklAj9mjQMokPtRZC1mR~bSgMoH0OL5fGtXKWCOUWMJM05L1VgQVJsdM7-uUoo5zz5Ii7ocsARn1csAYPaWXaIc7RO0bWVhIP4svDkIVbYSzf0sZfd2JZ64aSnKorkbuhvkcv4g-t2XwiEfayKptqrzaRJEHBD3W1-gGIHiSHg__")
            .into(city2.cityImage)
        Glide.with(city3.cityImage).load("https://s3-alpha-sig.figma.com/img/20c4/0e58/31db33f6c0036b9bbae6321c0b6e85b0?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=n6oKZATyp8cYHgDon-qpi0rvl7STD~qIW3Q1SrPanjXZCWaSK37v6UjUQgFyEft~avZFO84HtXGC2F9sry3sOCfSdspxsdYJqt4~Mp1hLJzIdf3oCnTCJNbnQUpVP8ZfE6rQXsLzbW2ufi3iH~RdhTEzOPFyI9b7RsKyacuH~7cwEVbNFVFKqys0I-PFwYIiTt~pkuBLoTF-CWGk8jN~tUqOE1vWKgcWUpr6u8vgdEXvKtcGg-y49Xz3KEYBZ0pSHtA0LOZZFCFgheJxBBE62RfZkCADFLFTNcF3IgpJialggGoOR68~zPhXuTmqwh5NakWJmpnELZR0pZ-k1W-TwA__")
            .into(city3.cityImage)

        city2.root.setOnClickListener {
            val DELAY_MILLIS = 1000L
            val handler = Handler(Looper.getMainLooper())
            var runnable: Runnable? = null
            view.toEditTxt.setText(city2.cityTxt.text)
            runnable?.let { handler.removeCallbacks(it) }
            runnable = Runnable {
                if (view.toEditTxt.text!!.isNotEmpty()) {
                    dialog.dismiss()
                    viewModel.saveFinalDestination(view.toEditTxt.text.toString())
                    viewModel.nextScreen()
                }
            }

            handler.postDelayed(runnable!!, DELAY_MILLIS)
        }

        city3.root.setOnClickListener {
            val DELAY_MILLIS = 1000L
            val handler = Handler(Looper.getMainLooper())
            var runnable: Runnable? = null
            view.toEditTxt.setText(city3.cityTxt.text)
            runnable?.let { handler.removeCallbacks(it) }
            runnable = Runnable {
                if (view.toEditTxt.text!!.isNotEmpty()) {
                    dialog.dismiss()
                    viewModel.saveFinalDestination(view.toEditTxt.text.toString())
                    viewModel.nextScreen()
                }
            }

            handler.postDelayed(runnable!!, DELAY_MILLIS)
        }

        city1.root.setOnClickListener {
            val DELAY_MILLIS = 1000L
            val handler = Handler(Looper.getMainLooper())
            var runnable: Runnable? = null
            view.toEditTxt.setText(city1.cityTxt.text)
            runnable?.let { handler.removeCallbacks(it) }
            runnable = Runnable {
                if (view.toEditTxt.text!!.isNotEmpty()) {
                    dialog.dismiss()
                    viewModel.saveFinalDestination(view.toEditTxt.text.toString())
                    viewModel.nextScreen()
                }
            }

            handler.postDelayed(runnable!!, DELAY_MILLIS)
        }

        view.toEditTxt.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                val text = view.toEditTxt.text.toString()
                if (text.isNotEmpty()) {
                    dialog.dismiss()
                    viewModel.saveFinalDestination(text)
                    viewModel.nextScreen()
                }
                true // Return true to indicate that the event has been consumed
            } else {
                false // Return false to indicate that the event has not been consumed
            }
        }

        view.anywhereBtn.setOnClickListener {
            val DELAY_MILLIS = 1000L
            val handler = Handler(Looper.getMainLooper())
            var runnable: Runnable? = null
            view.toEditTxt.setText("Сочи")
            runnable?.let { handler.removeCallbacks(it) }
            runnable = Runnable {
                if (view.toEditTxt.text!!.isNotEmpty()) {
                    dialog.dismiss()
                    viewModel.saveFinalDestination(view.toEditTxt.text.toString())
                    viewModel.nextScreen()
                }
            }

            handler.postDelayed(runnable!!, DELAY_MILLIS)
        }

        view.bestsBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Горячие билеты", Toast.LENGTH_SHORT).show()
        }
        view.calendarBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Выходные", Toast.LENGTH_SHORT).show()
        }
        view.tripBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Сложный маршрут", Toast.LENGTH_SHORT).show()
        }

        dialog.setContentView(view.root)

        dialog.show()
    }

    private fun adapterSetUp(){
        binding.offersRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.offersRv.adapter = adapter
    }

    private fun observeOffers(){
        viewModel.offersResponse.observe(viewLifecycleOwner) { status ->
            when (status) {
                is NetworkStatus.Success -> adapter.submitList(status.data)
                is NetworkStatus.Error -> Toast.makeText(
                    requireContext(),
                    status.message,
                    Toast.LENGTH_SHORT
                ).show()

                else -> {}
            }
        }
    }

    private fun fragmentListeners(){

        binding.toEditTxt.setOnFocusChangeListener { view, focus ->
            if (focus){
                showModalScreen()
                viewModel.saveDestination(binding.fromEditTxt.text.toString())
            }
        }

    }

}
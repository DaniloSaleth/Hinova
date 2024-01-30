package com.example.hinova.ui.home.fragment.workshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hinova.databinding.FragmentWorkshopBinding
import org.koin.android.ext.android.inject

class WorkshopFragment : Fragment() {

    private val viewModel: WorkshopViewModel by inject()
    private var binding: FragmentWorkshopBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentWorkshopBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.state.observe(this.viewLifecycleOwner) { state ->
            when (state) {
                is WorkshopState.Loading -> {
                    // Show loading
                }
                is WorkshopState.Success -> {
                    state.result
                }
                is WorkshopState.Error -> {
                    // Show error
                }
                else -> {
                    // Show empty
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
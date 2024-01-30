package com.example.hinova.ui.home.fragment.workshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.hinova.databinding.FragmentWorkshopBinding
import com.example.hinova.model.Workshop
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
        viewModel.getWorkshops(601)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.state.observe(this.viewLifecycleOwner) { state ->
            setupState()
            when (state) {
                is WorkshopState.Loading -> showLoading()
                is WorkshopState.Success -> showWorkshops(state.result.ListaOficinas)
                is WorkshopState.Error -> showError(state.message)
                else -> {
                    // Show empty
                }
            }
        }
    }

    private fun setupState(){
        binding?.loadingProgressBar?.isVisible = false
        binding?.workshopRecyclerView?.isVisible = false
        binding?.errorMessage?.isVisible = false
    }

    private fun showLoading() {
        binding?.loadingProgressBar?.isVisible = true
    }

    private fun showWorkshops(workshops: List<Workshop>) {
        binding?.workshopRecyclerView?.isVisible = true
        binding?.workshopRecyclerView?.adapter = WorkshopAdapter(workshops)
    }

    private fun showError(message: String) {
        binding?.errorMessage?.isVisible = true
        binding?.errorMessage?.text = message
    }

    private fun toast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
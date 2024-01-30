package com.example.hinova.ui.home.fragment.invite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hinova.databinding.FragmentInviteBinding
import com.example.hinova.infrastructure.UserDataManager
import com.example.hinova.model.InviteAFriendData
import org.koin.android.ext.android.inject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class InviteFragment : Fragment() {

    private val viewModel: InviteViewModel by inject()
    private var binding: FragmentInviteBinding? = null
    private var userData = UserDataManager.getInstance().getUserData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentInviteBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.state.observe(this.viewLifecycleOwner) { state ->
            when (state) {
                is InviteState.Loading -> {
                    // Show loading
                }
                is InviteState.Success -> showSuccess()
                is InviteState.Error -> showError()
            }
        }
    }

    private fun showError() {
        toast("Erro ao enviar convite, tente novamente!")
    }

    private fun showSuccess() {
        toast("Convite enviado com sucesso!")
    }

    private fun toast(message: String) {
        binding?.etName?.text?.clear()
        binding?.etEmail?.text?.clear()
        binding?.etPhone?.text?.clear()
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun setupListeners() {
        binding?.btnInvite?.setOnClickListener {
            viewModel.inviteFriend(createInviteObject())
        }
    }

    private fun createInviteObject(): InviteAFriendData {
        return InviteAFriendData(
            CodigoAssociacao = userData.mobileCode,
            DataCriacao = getCurrentDate(),
            CpfAssociado = userData.cpf,
            EmailAssociado = userData.email,
            NomeAssociado = userData.name,
            TelefoneAssociado = userData.phone,
            PlacaVeiculoAssociado = "",
            NomeAmigo = binding?.etName?.text.toString(),
            EmailAmigo = binding?.etEmail?.text.toString(),
            TelefoneAmigo = binding?.etPhone?.text.toString(),
            Observacao = ""
        )
    }

    private fun getCurrentDate(): String {
        val currentDate = LocalDate.now()
        val date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return currentDate.format(date)
    }
}
package com.example.hinova.model

data class Workshop(
    val Id: Int,
    val Nome: String,
    val Descricao: String,
    val DescricaoCurta: String,
    val Endereco: String,
    val Latitude: Double,
    val Longitude: Double,
    val Foto: String,
    val AvaliacaoUsuario: Int,
    val CodigoAssociacao: Int,
    val Email: String,
    val Telefone1: String,
    val Telefone2: String,
    val Ativo: Boolean,
)
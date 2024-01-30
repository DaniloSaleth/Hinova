package com.example.hinova.model

import android.os.Parcel
import android.os.Parcelable

data class InviteAFriendData(
    val CodigoAssociacao: Int,
    val DataCriacao: String,
    val CpfAssociado: String,
    val EmailAssociado: String,
    val NomeAssociado: String,
    val TelefoneAssociado: String,
    val PlacaVeiculoAssociado: String,
    val NomeAmigo: String,
    val TelefoneAmigo: String,
    val EmailAmigo: String,
    val Observacao: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(CodigoAssociacao)
        parcel.writeString(DataCriacao)
        parcel.writeString(CpfAssociado)
        parcel.writeString(EmailAssociado)
        parcel.writeString(NomeAssociado)
        parcel.writeString(TelefoneAssociado)
        parcel.writeString(PlacaVeiculoAssociado)
        parcel.writeString(NomeAmigo)
        parcel.writeString(TelefoneAmigo)
        parcel.writeString(EmailAmigo)
        parcel.writeString(Observacao)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InviteAFriendData> {
        override fun createFromParcel(parcel: Parcel): InviteAFriendData {
            return InviteAFriendData(parcel)
        }

        override fun newArray(size: Int): Array<InviteAFriendData?> {
            return arrayOfNulls(size)
        }
    }
}
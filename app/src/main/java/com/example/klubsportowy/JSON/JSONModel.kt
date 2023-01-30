package com.example.klubsportowy.JSON

import com.google.gson.annotations.SerializedName

data class JSONModel(
    var players:List<Players>?
)
data class Players (

    @SerializedName("id")
    val playerID: String?,

    val player: Player?

)

data class Player(
    val imie: String?,
    val nazwisko: String?,
    val wiek: Int?,
    val pozycja: String?,
    val zdjecie: String?,
    val narodowosc: String?,
    val statystyki: statystyki?
)

data class statystyki(
    val mecze: Int?,
    val gole: Int?,
    val asysty: Int?

)
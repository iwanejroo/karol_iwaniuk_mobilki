package com.example.klubsportowy.model


data class Players(
    val players:ArrayList<jsonModelClass>
)
data class jsonModelClass (
    val imie: String,
    val nazwisko: String,
    val wiek: Int,
    val pozycja: String,
    val zdjecie: String,
    val data_zatrudnienia: String,
    val dane_kontaktowe: dane_kontaktowe,
    val adres_zamieszkania: adres_zamieszkania,
    val srcimage: String
)

data class dane_kontaktowe(
    val adres_email: String,
    val nr_telefonu: String,

)

data class adres_zamieszkania(
    val miasto: String,
    val ulica: String,
    val nr_domu: String
)
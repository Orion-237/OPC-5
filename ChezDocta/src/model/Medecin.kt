package model

import java.time.LocalDate
import java.time.LocalTime


data class Medecin(
    val nom:String,
    val pwd:String,
    var jourDisponible: MutableList<Pair<Pair<LocalDate, LocalTime>,String>>? = mutableListOf()
)
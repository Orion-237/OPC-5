package model

import java.time.LocalDate
import java.time.LocalTime

data class RendezVous (
    val pair : Pair<LocalDate,LocalTime>,
    val medecin : String,
    val patient : String
)
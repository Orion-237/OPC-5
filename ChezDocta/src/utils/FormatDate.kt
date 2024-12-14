package utils

import java.time.LocalTime
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

data class FormatDate(
    val date: LocalDate,
    val time: LocalTime
) {
    companion object {
        private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        private val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

        fun fromStrings(dateStr: String, timeStr: String): Pair<LocalDate, LocalTime>? {
            return try {
                val parsedDate = LocalDate.parse(dateStr, dateFormatter)
                val parsedTime = LocalTime.parse(timeStr, timeFormatter)
                Pair(parsedDate, parsedTime)
            } catch (e: DateTimeParseException) {
                println("Erreur : Format invalide. Date attendue: yyyy-MM-dd, Heure attendue: HH:mm")
                null
            }
        }
    }

    fun formatted(): String {
        return "Date : ${date.format(dateFormatter)}, Heure : ${time.format(timeFormatter)}"
    }
}

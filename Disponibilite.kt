data class Disponibilite(val jour: String, val heure: String)

fun validerHeure(heure: String): Boolean {
    return Regex("^[0-2]\\d:[0-5]\\d$").matches(heure)
}

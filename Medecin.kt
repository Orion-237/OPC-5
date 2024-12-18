import java.util.*

data class Medecin(val nom: String, val disponibilites: MutableList<Disponibilite> = mutableListOf()) {

    fun ajouterDisponibilite(disponibilite: Disponibilite) {
        if (!disponibilites.contains(disponibilite)) {
            disponibilites.add(disponibilite)
            println("✔️ Créneau ajouté : ${disponibilite.jour} à ${disponibilite.heure} pour Dr $nom.")
        } else {
            println("⚠️ Le créneau ${disponibilite.jour} à ${disponibilite.heure} est déjà disponible pour Dr $nom.")
        }
    }

    fun afficherDisponibilites() {
        if (disponibilites.isEmpty()) {
            println("❌ Aucune disponibilité pour Dr $nom.")
        } else {
            println("📅 Disponibilités pour Dr $nom :")
            disponibilites.forEach { println("- ${it.jour} à ${it.heure}") }
        }
    }

   
}

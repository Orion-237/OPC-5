import java.io.File

data class RendezVous(val medecin: Medecin, val patient: Patient, val disponibilite: Disponibilite)

class GestionRendezVous(private val fichierRendezVous: String = "rendezvous.txt") {

    fun sauvegarder(rendezVous: RendezVous) {
        val ligne = "${rendezVous.medecin.nom},${rendezVous.patient.nom},${rendezVous.disponibilite.jour},${rendezVous.disponibilite.heure}\n"
        File(fichierRendezVous).appendText(ligne)
        println("✔️ Rendez-vous enregistré : Dr ${rendezVous.medecin.nom} avec ${rendezVous.patient.nom} le ${rendezVous.disponibilite.jour} à ${rendezVous.disponibilite.heure}.")
    }

    fun charger(): List<RendezVous> {
        val file = File(fichierRendezVous)
        if (!file.exists()) return emptyList()

        return file.readLines().mapNotNull { ligne ->
            val parts = ligne.split(",")
            if (parts.size == 4) {
                val (nomMedecin, nomPatient, jour, heure) = parts
                val medecin = Medecin(nomMedecin)
                val patient = Patient(nomPatient)
                val disponibilite = Disponibilite(jour, heure)
                RendezVous(medecin, patient, disponibilite)
            } else null
        }
    }

    fun afficherTous() {
        val rendezVous = charger()
        if (rendezVous.isEmpty()) {
            println("❌ Aucun rendez-vous enregistré.")
        } else {
            println("📋 Liste des rendez-vous :")
            rendezVous.forEach {
                println("📅 Dr ${it.medecin.nom} avec ${it.patient.nom} le ${it.disponibilite.jour} à ${it.disponibilite.heure}.")
            }
        }
    }

    fun supprimer(medecinNom: String, jour: String, heure: String) {
        val rendezVous = charger().toMutableList()
        val rendezVousASupprimer = rendezVous.find {
            it.medecin.nom == medecinNom && it.disponibilite.jour == jour && it.disponibilite.heure == heure
        }
        if (rendezVousASupprimer != null) {
            rendezVous.remove(rendezVousASupprimer)
            File(fichierRendezVous).writeText(
                rendezVous.joinToString("\n") { "${it.medecin.nom},${it.patient.nom},${it.disponibilite.jour},${it.disponibilite.heure}" }
            )
            println("✔️ Rendez-vous supprimé pour Dr $medecinNom le $jour à $heure.")
        } else {
            println("❌ Aucun rendez-vous trouvé pour Dr $medecinNom le $jour à $heure.")
        }
    }
}

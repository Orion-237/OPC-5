package utils

import entities.Medecin
import kotlin.random.Random

class MedecinFactory {
    private val noms = listOf(
        "Pr Liam Ndjock", "Dr Francis Talla ", "Pr Mathieu Ntono",
        "Dr Weber", "Dr Alex", "Dr Synthia", "Dr Nelson",
        "Dr Jean Pierre Atangana", "Dr Anderson", "Dr Sibelle"
    )
    private val specialites = listOf(
        "Cardiologie", "Neurologie", "Pédiatrie", "Gynécologie",
        "Dermatologie", "Orthopédie", "Oncologie",
        "Psychiatrie", "Ophtalmologie", "Anesthésiologie"
    )

    fun creerListeMedecins(nb: Int): MutableList<Medecin> {
        val medecins = mutableListOf<Medecin>()
        for (i in 0..<nb) {
            val id = i+1
            val nom = noms[i]
            val specialite = specialites[Random.nextInt(specialites.size)]
            medecins.add(Medecin(id, nom, specialite))
        }
        return medecins
    }
}
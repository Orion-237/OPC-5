package repository

import model.RendezVous
import java.time.LocalDate
import java.time.LocalTime

val listeRendezVous = mutableListOf<RendezVous>()

interface RensezVousRepository {
    fun addRendezvous(patient: String, medecin : String, pair :Pair<LocalDate,LocalTime>) : Boolean
    fun getRendezvous() : MutableList<RendezVous>
    fun deleteByindex(index :Int) : Boolean
}

class RendezVousRepositoryImpl : RensezVousRepository{

    override fun addRendezvous(patient: String, medecin : String, pair :Pair<LocalDate,LocalTime>) : Boolean{
        listeRendezVous.add(RendezVous(pair,medecin,patient))
        return true
    }

    override fun getRendezvous() : MutableList<RendezVous> {
        return listeRendezVous
    }

    override fun deleteByindex(index :Int) : Boolean{
        listeRendezVous.removeAt(index-1)
        return true
    }


}
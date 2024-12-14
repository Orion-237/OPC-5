package repository

import model.Medecin
import model.Patient
import java.time.LocalDate
import java.time.LocalTime

val listeMedecin = listOf(
    Medecin("goube", "12345"),
    Medecin("eric", "12345")
)

val listePatient = listOf(
    Patient("patient", "12345")
)

interface UserRepository {

    fun getAllPlaning() : List<Medecin>
    fun updateOnePlaning(index :Int, nom: String) : Pair<LocalDate, LocalTime>
    fun getPlaning(nomm : String) : MutableList<Pair<Pair<LocalDate, LocalTime>,String>>
    fun updateMedecin(nomm : String, pair : Pair<LocalDate,LocalTime>)
    fun deleteByindex(nom: String,index :Int)
    fun loginMedecin(nomm : String,pwd : String) : Boolean
    fun loginPatient(nomm : String,pwd : String) : Boolean

}

class UserRepositoryImpl : UserRepository {

    override fun getAllPlaning() : List<Medecin>{
        return  listeMedecin
    }

    override fun getPlaning(nomm : String) : MutableList<Pair<Pair<LocalDate, LocalTime>, String>> {
        val medecin = listeMedecin.find { it.nom == nomm }
        return medecin?.jourDisponible ?: mutableListOf()

    }

    override fun updateOnePlaning(index :Int, nom: String) : Pair<LocalDate, LocalTime> {
        val medecin = listeMedecin.find { it.nom == nom }
        val ancienneDisponibilite = medecin?.jourDisponible!![index - 1]
        val nouvelleDisponibilite = ancienneDisponibilite.copy(second = "Indisponible")
        medecin?.jourDisponible!![index - 1] = nouvelleDisponibilite

        return nouvelleDisponibilite.first
    }
    override fun loginMedecin(nom : String,pwd : String) : Boolean{
        for ((nomm, mpwd) in listeMedecin){
            if (nom == nomm && pwd == mpwd) {
               return true
            }
        }
        return false
    }

    override fun loginPatient(nom : String,pwd : String) : Boolean{
        for ((nomm, mpwd) in listePatient){
            if (nom == nomm && pwd == mpwd) {
                return true
            }
        }
        return false
    }

    override fun deleteByindex(nomm: String,index :Int){
        val medecin = listeMedecin.find { it.nom == nomm }
        medecin?.jourDisponible?.removeAt(index-1)
    }


    override fun updateMedecin(nomm : String, pair : Pair<LocalDate,LocalTime>) {
        val medecin = listeMedecin.find { it.nom == nomm }
        medecin?.jourDisponible?.add(Pair(pair,"disponible"))

    }


}
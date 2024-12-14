package service

import model.Medecin
import repository.UserRepository
import repository.UserRepositoryImpl
import java.time.LocalDate
import java.time.LocalTime

class UserService {

    private val userRepository: UserRepository = UserRepositoryImpl()

    fun login(nom : String, pwd : String) : Boolean{
        println("Tentative de connexion...")
        return userRepository.loginMedecin(nom,pwd)
    }

    fun loginPatient(nom : String, pwd : String) : Boolean{
        println("Tentative de connexion...")
        return userRepository.loginPatient(nom,pwd)
    }

    fun addCreneau(nom: String,pair : Pair<LocalDate,LocalTime>){
        println("Tentative d'ajout...")
        userRepository.updateMedecin(nom,pair)
        println("créneaux ajouter avec succès !")
    }

    fun deleteCreneau(nom: String, index : Int) {
        userRepository.deleteByindex(nom,index)
    }

    fun getPlaning (nom: String) : MutableList<Pair<Pair<LocalDate, LocalTime>, String>>{
        return userRepository.getPlaning(nom)
    }

    fun getAllPlaning() : List<Medecin>{
        return userRepository.getAllPlaning()
    }

}
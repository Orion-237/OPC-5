package controller

import model.Medecin
import service.UserService
import utils.FormatDate
import java.time.LocalDate
import java.time.LocalTime

class UserCtrl {
    private val userService = UserService()

    fun login(nom: String, pwd: String): Boolean{
        println("Vérification des informations...")

        val result = userService.login(nom, pwd)

        if (result == true) {
            println("Bienvenue parmi nous, $nom ! 😊")
            return true
        } else {
            println("Erreur de connexion, veuillez vérifier vos informations.")
            return false
        }
    }

    fun loginPatient(nom: String, pwd: String): Boolean{
        println("Vérification des informations...")

        val result = userService.loginPatient(nom, pwd)

        if (result == true) {
            println("Bienvenue parmi nous, $nom ! 😊")
            return true
        } else {
            println("Erreur de connexion, veuillez vérifier vos informations.")
            return false
        }
    }

    fun ajouterCreneau(nom: String, date: String, heure: String ){
        val validDateTime = FormatDate.fromStrings(date, heure)
        if (validDateTime != null) {
            userService.addCreneau(nom,validDateTime)
        } else {
            println("Entrées invalides pour la date ou l'heure.")
        }
    }

    fun deleteCreneau(nom: String, index : Int){
        if (index-1 in 0..getPlaning(nom).size){
            userService.deleteCreneau(nom, index)
        }
        println("Creneaux introuver")
    }

    fun getPlaning (nom: String) : MutableList<Pair<Pair<LocalDate, LocalTime>, String>>{
        return userService.getPlaning(nom)
    }

    fun getAllPlaning() : List<Medecin>{
        return userService.getAllPlaning()
    }
}

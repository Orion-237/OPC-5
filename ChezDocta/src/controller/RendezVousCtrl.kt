package controller

import model.RendezVous
import service.RendezvousService


class RendezVousCtrl {
    private val rendezvousService = RendezvousService()

    fun addRendezvous(index: Int,patient: String, medecin: String){
        println("Vérification des informations...")
        if ( rendezvousService.addRendezvous(index,patient,medecin)  == true ){
            println("✅ Rendez-vous pris avec succès")
        }else{
            println("Erreur de connexion, veuillez vérifier vos informations.")
        }

    }

    fun getRendezvous() : MutableList<RendezVous>{
        return rendezvousService.getRendezvous()
    }

    fun annulerRendezvous(index: Int){
        if (rendezvousService.annuleRendezvous(index) == true ){
            println("✅ Rendez-vous annuler avec succès")
        }
    }
}
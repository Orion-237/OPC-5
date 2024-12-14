package ui.composant

import model.Medecin
import ui.currentUser
import ui.demanderRole
import ui.userCtrl
import ui.rendezVousCtrl

val disponibilitesIndexees = mutableListOf<Pair<Int, Medecin,>>()

fun menuPatient() {
    var continuer = true

    while (continuer) {
        println("""
                ##################################################
                #               Menu du Patient                  #
                #                                                #
                #    1. 📅 Afficher les créneaux disponibles     #
                #    2. ✍️ Réserver un rendez-vous               #
                #    3. 🗒️ Afficher tous vos rendez-vous pris    #
                #    4. 🗒️ Annuler un rendez vous                #
                #    5. Déconnexion                              #
                #    6. Sortir du programme                      #
                #                                                #
                ##################################################
            """)

        print("Choisissez une option : ")
        val choix = readLine()?.toIntOrNull()

        when (choix) {
            1 -> {
                afficherToutJour()
            }
            2 -> {
                prendreRendezVous()
            }
            3 -> {
                afficheRendezvous()
            }
            4 -> {
                annulerRendezvous()
            }
            5 -> {
                println("Déconnexion réussie.")
                demanderRole()
            }
            6 -> {
                println("Aurevoir....")
                continuer = false
            }
            else -> println("Choix invalide. Veuillez entrer un nombre valide.")
        }
    }
}



fun ConnectionPatient(){
    println("🔒 Veuillez vous connecter en tant que Patient 🔑")

    print("Nom d'utilisateur : ")
    val username = readLine() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")

    print("Mot de passe      : ")
    val password = readLine() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")

    if (userCtrl.loginPatient(username, password) == true ){
        currentUser = username
        menuPatient()
    }else {
        ConnectionPatient()
    }

}

fun afficherToutJour() {

    val jours = userCtrl.getAllPlaning()


    println("Liste des jours et heures disponibles :")
    var index = 1
    for(jour in jours){
        if (jour.jourDisponible!!.isEmpty()){
            println("Aucun jour disponible.")
            return
        }
        println("Médecin: ${jour.nom}")
        for ((dateHeure,statut) in jour.jourDisponible!!){
            val (date, heure) = dateHeure
            println("${index}- Date : $date, Heure : $heure, Statut : $statut")
            disponibilitesIndexees.add(Pair(index,jour))
            index++
        }
    }

}

fun prendreRendezVous() {
    println("""
        ############################################################
        #                                                          #
        #          🗓️  Choisissez une disponibilité 🕒            #
        #                                                          #
        ############################################################
    """.trimIndent())

    afficherToutJour()
    val jours = userCtrl.getAllPlaning()
    print("👉 Entrez le numéro de l'horaire choisi : ")


    try {
        val choix = readLine()?.toIntOrNull() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")
        val choixTrouve = disponibilitesIndexees.find { it.first == choix }
        if (choixTrouve == null ) {
            println("⚠️  Choix invalide, veuillez réessayer.")
        }else {
            val (index, medecin) = choixTrouve
            val disponibilite = medecin.jourDisponible?.get(index - 1)
            if (disponibilite == null) {
                println("⚠️  La disponibilité sélectionnée est introuvable.")
            } else {
                val (_, statut) = disponibilite
                if (statut == "Disponible") {
                    rendezVousCtrl.addRendezvous(index, currentUser, medecin.nom)
                } else {
                    println("⚠️  Cette disponibilité n'est pas libre. Statut actuel : $statut")
                }
            }
        }
    }catch (e: NumberFormatException){
        println("\t Erreur : \uD83D\uDE21 Vous devez entrer un choix valide.")
    }

}

fun afficheRendezvous(){

    val rendezvous = rendezVousCtrl.getRendezvous()
    if (rendezvous.isEmpty()){
        println("Aucun rendez vous disponible.")
        return
    }
    var index = 1
    println("Liste des rendez vous pris :")
    for(rendezvou in rendezvous){
        val (date, heure) = rendezvou.pair
        println("${index}- Date : $date, Heure : $heure, Medecin : ${rendezvou.medecin},  Medecin : ${rendezvou.patient} ")
        index++
    }
}

fun annulerRendezvous() {
    println("""
        ############################################################
        #                                                          #
        #          🗓️  Annuler un rendez vous  🕒                   #
        #                                                          #
        ############################################################
    """.trimIndent())

    afficheRendezvous()
    val rendezvous = rendezVousCtrl.getRendezvous()

    if(rendezvous.isEmpty()){
        return
    }

    print("👉 Entrez le numéro du rendez vous choisi : ")

    try {
        val choix = readLine()?.toIntOrNull() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")
        if (rendezvous[choix-1].patient == currentUser ) {
            rendezVousCtrl.annulerRendezvous(choix)
        }else{
            println("Vous ne pouvez qu'annuler vos rendez vous ")
        }
    }catch (e: NumberFormatException){
        println("\t Erreur : \uD83D\uDE21 Vous devez entrer un choix valide.")
    }

}
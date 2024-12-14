package ui.composant

import ui.currentUser
import ui.demanderRole

import ui.userCtrl

fun menuMedecin() {
    var continuer = true

    while (continuer) {
        println("""
                ##################################################
                #               Menu du Médecin                  #
                #                                                #
                #    1. Ajouter un créneaux                      #
                #    2. Supprimer un créneaux                    #
                #    3. Afficher tout les créneaux               #
                #    4. Déconnexion                              #
                #    5. Sortir du programme                      #
                #                                                #
                ##################################################
            """)

        print("Choisissez une option : ")
        val choix = readLine()?.toIntOrNull()

        when (choix) {
            1 -> {
                addcreneau()
            }
            2 -> {
                supprimerCreneau()
            }
            3 -> {
                afficherJoursDisponibles()
            }
            4 -> {
                println("Déconnexion réussie.")
                demanderRole()
            }
            5 -> {
                println("Aurevoir.....")
                continuer = false
            }
            else -> println("Choix invalide. Veuillez entrer un nombre valide.")
        }
    }
}


fun ConnectionMedecin() {
    println("🔒 Veuillez vous connecter en tant que Médecin 🔑")

    print("Nom d'utilisateur : ")
    val username = readLine() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")

    print("Mot de passe      : ")
    val password = readLine() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")

    if (userCtrl.login(username, password) == true ){
        currentUser = username
        menuMedecin()
    }else {
        ConnectionMedecin()
    }

}

fun addcreneau() {
    println("🔒 Veuillez Entrez des information correct ")

    print("Entrez la date sous le format AAAA-MM-JJ : ")
    val date = readLine() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")

    print("Entrez la heure sous le format HH:MM     : ")
    val time = readLine() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")

    userCtrl.ajouterCreneau(currentUser,date,time)

}

fun afficherJoursDisponibles() {

    val jours = userCtrl.getPlaning(currentUser)
    if (jours.isEmpty()) {
        println("Aucun jour disponible.")
        return
    }

    println("Liste des jours et heures disponibles :")
    var index = 1
    for ((dateHeure,statut) in jours){
        val (date, heure) = dateHeure
        println("${index}- Date : $date, Heure : $heure, Statut : $statut")
        index++
    }

}

fun supprimerCreneau(){
    afficherJoursDisponibles()
    println("🔒 Veuillez Entrez le numero du créneaux  ")

    print("Numero : ")
    try {
        var nbr = readLine()?.toInt() ?: throw NumberFormatException("\t \uD83D\uDE22 Entrée vide")
        userCtrl.deleteCreneau(currentUser,nbr)
    }catch (e: NumberFormatException){
        println("\t Erreur : \uD83D\uDE21 Vous devez entrer un choix valide.")
    }

}
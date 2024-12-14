package ui

import controller.RendezVousCtrl
import controller.UserCtrl
import ui.composant.*


    var currentUser = ""
    val userCtrl = UserCtrl()
    val rendezVousCtrl = RendezVousCtrl()

    fun BienvenuComposent(){
        val welcomeMessage = """
            ##################################################
            #                                                #
            #        🎉 Bienvenue sur ChezDocta ! 🎉         #
            #                                                #
            ##################################################
            #                                                #
            #  Nous sommes ravis de vous voir ici !          #
            #  Profitez de toutes les fonctionnalités !      #
            #                                                #
            ##################################################
    """

        println(welcomeMessage)
    }

    fun demanderRole() {
        println("""
            ##################################################
            #                                                #
            #    Êtes-vous un médecin ou un patient ?       #
            #                                                #
            ##################################################
        """)

        println("1. Médecin")
        println("2. Patient")

        print("Veuillez choisir une option (1 ou 2) : ")
        val choix = readLine()?.toIntOrNull()

        when (choix) {
            1 -> {
                println("Vous avez choisi : Médecin")
                ConnectionMedecin()
            }
            2 -> {
                println("Vous avez choisi : Patient")
                ConnectionPatient()
            }
            else -> {
                println("Choix invalide. Veuillez entrer 1 ou 2.")
                demanderRole()
            }
        }
    }








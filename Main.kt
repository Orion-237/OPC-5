fun main() {
    val medecins = mutableListOf<Medecin>()
    val gestionRendezVous = GestionRendezVous()

    while (true) {
        println("\nMenu principal 📋 :")
        println("1️⃣ Ajouter un médecin")
        println("2️⃣ Ajouter une disponibilité pour un médecin")
        println("3️⃣ Afficher les disponibilités d'un médecin")
        println("4️⃣ Réserver un rendez-vous")
        println("5️⃣ Afficher tous les rendez-vous")
        println("6️⃣ Supprimer un rendez-vous")
        println("7️⃣ Quitter")

        print("Choisissez une option : ")
        when (readln().toIntOrNull()) {
            1 -> ajouterMedecin(medecins)
            2 -> ajouterDisponibilite(medecins)
            3 -> afficherDisponibilites(medecins)
            4 -> reserverRendezVous(medecins, gestionRendezVous)
            5 -> gestionRendezVous.afficherTous()
            6 -> supprimerRendezVous(gestionRendezVous)
            7 -> break
            else -> println("❌ Option invalide. Veuillez réessayer.")
        }
    }
}

fun ajouterMedecin(medecins: MutableList<Medecin>) {
    print("Nom du médecin : ")
    val nomMedecin = readln()
    if (medecins.none { it.nom == nomMedecin }) {
        medecins.add(Medecin(nomMedecin))
        println("✔️ Médecin ajouté : Dr $nomMedecin.")
    } else {
        println("⚠️ Dr $nomMedecin existe déjà.")
    }
}

fun ajouterDisponibilite(medecins: MutableList<Medecin>) {
    print("Nom du médecin : ")
    val nomMedecin = readln()
    val medecin = medecins.find { it.nom == nomMedecin }
    if (medecin != null) {
        print("Entrez le jour (ex : lundi) : ")
        val jour = readln()
        print("Entrez l'heure (HH:mm) : ")
        val heure = readln()
        if (validerHeure(heure)) {
            medecin.ajouterDisponibilite(Disponibilite(jour, heure))
        } else {
            println("❌ Format de l'heure invalide. Veuillez utiliser le format HH:mm.")
        }
    } else {
        println("❌ Médecin non trouvé.")
    }
}


fun afficherDisponibilites(medecins: MutableList<Medecin>) {
    print("Nom du médecin : ")
    val nomMedecin = readln()
    val medecin = medecins.find { it.nom == nomMedecin }
    medecin?.afficherDisponibilites() ?: println("❌ Médecin non trouvé.")
}

fun reserverRendezVous(medecins: MutableList<Medecin>, gestionRendezVous: GestionRendezVous) {
    print("Nom du médecin : ")
    val nomMedecin = readln()
    val medecin = medecins.find { it.nom == nomMedecin }
    if (medecin != null) {
        print("Entrez le jour : ")
        val jour = readln()
        print("Entrez l'heure : ")
        val heure = readln()
        val disponibilite = Disponibilite(jour, heure)
        if (medecin.disponibilites.contains(disponibilite)) {
            print("Nom du patient : ")
            val nomPatient = readln()
            val patient = Patient(nomPatient)
            medecin.disponibilites.remove(disponibilite)
            gestionRendezVous.sauvegarder(RendezVous(medecin, patient, disponibilite))
        } else {
            println("❌ Créneau non disponible.")
        }
    } else {
        println("❌ Médecin non trouvé.")
    }
}

fun supprimerRendezVous(gestionRendezVous: GestionRendezVous) {
    print("Nom du médecin : ")
    val nomMedecin = readln()
    print("Entrez le jour : ")
    val jour = readln()
    print("Entrez l'heure : ")
    val heure = readln()
    gestionRendezVous.supprimer(nomMedecin, jour, heure)
}

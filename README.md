# Gestion de Prise de Rendez-Vous chez DOCTA 🏥💻

## Contexte 🌟

Vous êtes chargé de développer une application console en Kotlin permettant de gérer la prise de rendez-vous entre des médecins et des patients chez DOCTA. 
L'objectif principal est de permettre :
- 👨‍⚕️ Aux médecins de définir leurs jours et heures de disponibilité.
- 👩‍⚕️ Aux patients de consulter ces disponibilités et réserver un créneau horaire.
- 📋 À l'application d'afficher les rendez-vous pris et les créneaux disponibles.

## Objectifs de l'exercice 🎯

### Compétences visées 🎓
- ⚙️ Manipuler les collections et classes en Kotlin.
- 💡 Implémenter un programme interactif avec une interface en ligne de commande.
- 🏗️ Structurer et organiser une application modulaire.
- ✅ Gérer les validations et les exceptions courantes dans les systèmes de réservation.

### Fonctionnalités demandées 📌
1. **Gestion des disponibilités des médecins** :
   - ➕ Ajouter des créneaux disponibles pour un médecin (jour et heure).
   - 👁️ Afficher toutes les disponibilités d'un médecin.

2. **Gestion des rendez-vous des patients** :
   - 📅 Afficher les créneaux disponibles.
   - ✍️ Réserver un rendez-vous pour un patient (associer un créneau à un nom de patient).
   - 🚫 Vérifier qu'un créneau réservé ne peut pas être attribué à deux patients.

3. **Affichage des rendez-vous** :
   - 🗒️ Afficher tous les rendez-vous pris, avec les détails (médecin, jour, heure, patient).

### Bonus 🌟
- ✏️ Permettre au médecin de modifier ou supprimer des créneaux de disponibilité.
- ❌ Ajouter la possibilité pour un patient d'annuler un rendez-vous.

## Consignes 📜

1. **Structure du projet** 🏗️ :
   - Utilisez des classes pour représenter les entités principales (`entities.Medecin`, `entities.RendezVous`).
   - Organisez votre code en fonctions pour chaque action (exemple : ajouter des disponibilités, afficher les rendez-vous, etc.).

2. **Interface utilisateur** 🎨 :
   - L'interaction doit se faire uniquement via la console.
   - Proposez un menu principal avec des options claires pour chaque fonctionnalité.

3. **Validation des entrées** ✅ :
   - Gérez les cas d'erreurs (choix invalide, créneau déjà réservé, etc.).
   - Assurez-vous que les données saisies sont correctes (par exemple, un horaire doit respecter le format `HH:mm`).

4. **Présentation des résultats** 📊 :
   - Utilisez des affichages clairs et lisibles pour informer l'utilisateur des opérations effectuées (par exemple : « Rendez-vous pris avec succès ! »).

## Déroulement de l'exercice 🛠️

1. **Analyse** 🔍 :
   - Étudiez les fonctionnalités demandées et réfléchissez à la structure de votre programme.

2. **Conception** ✍️ :
   - Identifiez les classes, leurs attributs et méthodes.
   - Décidez comment organiser les interactions entre les différentes entités.

3. **Implémentation** 💻 :
   - Écrivez votre code en respectant les consignes données.
   - Testez chaque fonctionnalité pour vérifier son bon fonctionnement.

4. **Améliorations** 🚀 :
   - Si vous avez du temps, ajoutez les fonctionnalités bonus.

## Ressources 📚
- [📘 Documentation officielle Kotlin](https://kotlinlang.org/docs/home.html)
- [📖 Guide sur les collections en Kotlin](https://kotlinlang.org/docs/collections-overview.html)

## Évaluation 📝
Votre travail sera évalué sur les critères suivants :
- ✅ Respect des consignes.
- 🤓 Bonne utilisation des concepts Kotlin.
- ⚠️ Gestion des validations et des erreurs.
- ✨ Clarté et lisibilité du code.
- 🎨 Qualité de l'interface console et des interactions utilisateur.

---

Bonne chance ! 🚀😊

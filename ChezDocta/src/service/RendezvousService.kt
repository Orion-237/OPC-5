package service


import model.RendezVous
import repository.RendezVousRepositoryImpl
import repository.RensezVousRepository
import repository.UserRepository
import repository.UserRepositoryImpl

class RendezvousService {

    private val rendezVousRepository: RensezVousRepository = RendezVousRepositoryImpl()
    private val userRepository: UserRepository = UserRepositoryImpl()


    fun addRendezvous(index: Int,patient:String,medecin: String) : Boolean{
        val pair = userRepository.updateOnePlaning(index,medecin)
        if ( rendezVousRepository.addRendezvous(patient,medecin,pair) ){
            return true
        }else{
            return false
        }
    }

    fun getRendezvous() : MutableList<RendezVous>{
        return rendezVousRepository.getRendezvous()
    }

    fun annuleRendezvous(index: Int) : Boolean{
        return rendezVousRepository.deleteByindex(index)
    }
}
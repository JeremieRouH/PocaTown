class BatimentHopitalGeneral(var height: Int, var width: Int, var coutMaintien: Int, var santé: Int,
  var effectifMax: Int, var effectifActuel: Int, var salaire: Int) extends Batiments with Soigner with EstTravail {

  var radius = height * width

  def obtenirSoin(vie: Int): Int = {
    return santé + vie
  }

  def estEnBonneSante(vie: Int): Boolean = {
    var resultat = false
    if (vie >= 50) { // la santé d un sim va de 0 (mort) a 100 (naissance)
      resultat = true
    } else {
      resultat = false
    }
    return resultat
  }

  
  
  
  /* code dupliqué : la raison c est que ces 2 fonctions sont communes à tous les batiments */

  def efficacite(): Double = {
    var efficaciT = effectifMax / radius
    return efficaciT

  }

  def cout(): Int = {
    return coutMaintien + effectifActuel * salaire
  }

  // ----------------------------------

}
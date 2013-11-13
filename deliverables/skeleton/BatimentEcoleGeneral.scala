class BatimentEcoleGeneral(var height: Int, var width: Int, var coutMaintien: Int, var education: Int,
  var effectifMax: Int, var effectifActuel: Int, var salaire: Int) extends Batiments with Scolariser with EstTravail {

	var radius = height * width
	
	def estEduqu�(education:Int):Boolean ={
	  if(education > 0){
	    return true
	  } else{
	    return false
	  }
	}
	
	def niveauScolaire():Int = {
	  return education
	}
	
	/* code dupliqu� : la raison c est que ces 2 fonctions sont communes � tous les batiments */

  def efficacite(): Double = {
    var efficaciT = effectifMax / radius
    return efficaciT

  }

  def cout(): Int = {
    return coutMaintien + effectifActuel * salaire
  }

  // ----------------------------------
}
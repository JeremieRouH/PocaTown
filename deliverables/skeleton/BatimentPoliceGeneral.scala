class BatimentPoliceGeneral(var height: Int, var width: Int, var salaire: Int,
  var effectifMax: Int, var coutMaintien: Int) extends Batiments with EstTravail {
  effectifActuel = 0

  //effectifMax = height* width*4
  var radius = height * width
  
  //salaire fixe
  //-------------- dup --------
  def efficacite():Double=  {
        var efficaciT = effectifMax/radius 
        return efficaciT
    
  }
  
  
  def cout():Int= {
	  return coutMaintien + effectifActuel*salaire
  }
  //-----------------------------
  
  def arrestCriminal() {
    
  }
  
  def reduceCrime() {
    
  }

  def estCorrompu(newSalaire:Int):Boolean ={
    var reponse = false
    if(newSalaire > salaire){
      reponse = true
    }
    return reponse
  }
  
  
  
}
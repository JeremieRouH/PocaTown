class BatimentPompierGeneral(var height: Int, var width: Int, var coutMaintien: Int, var feu: Boolean,
  var effectifMax: Int, var effectifActuel: Int, var salaire: Int) extends Batiments with Soigner with EstTravail {

  var radius = height * width
  
  
  def estEnFeu(feu:Boolean):Boolean ={// super useless
    if(feu){
      return true
    } else {
      return false
    }
  }
  
  def extinction(){
    
  }
  
  
  
  //-------------- dup --------
  def efficacite():Double=  {
        var efficaciT = effectifMax/radius 
        return efficaciT
    
  }
  
  
  def cout():Int= {
	  return coutMaintien + effectifActuel*salaire
  }
  //-----------------------------
  
  
}
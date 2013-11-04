abstract class Zone {
  var niveau_evolution:Int //0 pour non construit, en construction
  var taux:List[Taux]
  def peuxEvoluer 	//Regarde les taux pour savoir si les conditions sont bonne, 
  					//doit aussi vérifier si il y a tous les connecteurs nécessaire
  
}

abstract class Batiment {
  var coutMaintien:Int
  val effectifMax:Int
  var effectifActuel:Int
}

abstract class Connecteur {
  val estSurPlanAPart:Boolean
}

abstract class Effet {
  var rayon:Int
  var duree:Int
}

abstract class Taux {
  //Je pense que cette classe ne sert a rien... on y revien
}

abstract class Ville {
  val hauteur:Int
  val largeur:Int
}
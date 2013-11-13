abstract class Zone {
  var niveau_evolution:Int //0 pour non construit, en construction
  var taux:List[Taux]
  def peuxEvoluer 	//Regarde les taux pour savoir si les conditions sont bonne, 
  					//doit aussi vérifier si il y a tous les connecteurs nécessaire
  def evolue:Boolean
  
}

trait Residentielle {
  def Evolue(){}
}
trait Commerciale {
  var stock:Int

}
trait Industrielle {
  var niveau_pollution:Int
  
}

trait Producteur {
  var production:Int
}

trait EstTravail {
  var salaire:Int
  var effectifMax:Int
  var effectifActuel:Int
  
}

trait Agricole {
	
}

abstract class Batiment {
  var coutMaintien:Int
  val effectifMax:Int
  var effectifActuel:Int
  var niveau_evolution:Int
  var derEvolution:Int
}

trait Scolariser {}
trait Police {}
trait Pompier {}
trait EtudesSup {}
trait Eau {}
trait EnergieNucleaire {}
trait Soigner {}
trait Sante {}

abstract class Ecole extends Batiment with Scolariser
abstract class Commissariat extends Batiment with Police
abstract class CasernePompiers extends Batiment with Pompier
abstract class Universite extends Batiment with EtudesSup
abstract class ChateauDEau extends Batiment with Eau
abstract class CentraleNucleaire extends Batiment with EnergieNucleaire
abstract class Hopital extends Batiment with Soigner
abstract class Pharmacie extends Batiment with Sante


abstract class Connecteur {
  val estSurPlanAPart:Boolean
}

abstract class Effet {
  var rayon:Int
  var duree:Int
  var puissance:Int
}

abstract class Taux (var clef:String, var valeur:Double)

abstract class Ville {
  val hauteur:Int
  val largeur:Int
}

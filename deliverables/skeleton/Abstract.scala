abstract class Zone {
  var niveau_evolution:Int //0 pour non construit, en construction
  var taux:List[Taux]
  def peuxEvoluer 	//Regarde les taux pour savoir si les conditions sont bonne, 
  					//doit aussi vérifier si il y a tous les connecteurs nécessaire
  
}

trait Residentielle {
  def Evolue(){}
}
trait Commerciale {
  var augmenterSalaire:Boolean
  var agmenterStock:Boolean
  def Evolue(plusriche: Boolean)={
      if(plusriche)
	niveau_evolution=niveau_evolution+1
	augmenterSalaire=true
	augmenterStock=true	
  }
}
trait Industrielle {
  var niveau_pollution:Int
  def Evolue(plusDiplomes: Boolean)={
      if(plusDiplomes)
	niveau_evolution=niveau_evolution+1
	niveau_pollution=niveau_pollution+1
  }
}
trait Agricole {
  def Evolue()
}

class Residences extends Zone with Residentielle
class Commerces extends Zone with Commerciale
class Industries extends Zone with Industrielle
class Fermes extends Zone with Agricole

abstract class Batiment {
  var coutMaintien:Int
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

abstract class Taux {
  //Je pense que cette classe ne sert a rien... on y revien
}

abstract class Ville {
  val hauteur:Int
  val largeur:Int
}

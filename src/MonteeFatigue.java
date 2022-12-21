package tec;

/**
 * Implémentation d'une Montee Fatigue.
 *
 * Lors de la montee dans un vehicule, demande
 * une place assise sinon reste dehors
 */

class MonteeFatigue extends PassagerAbstrait {

  /** 
   * Constructeur
   *
   * @param nom le nom du passager
   * @param destination le numéro d'arrêt où il descend
   * @param a le comportement à l'arret
   *
   */
  public MonteeFatigue(String nom , int destination, ComportementArret a){
    super(nom, destination, a);
  }

  /**
   * Monte dans un véhicule donné.
   * Par choix d'implémentation, monte en position assise
   * sinon reste dehors.
   * @param v le véhicule dans lequel le passager monte
   */
  final protected void choixPlaceMontee(Vehicule v){
    if (v.aPlaceAssise()){
      v.monteeDemanderAssis(this);     
    }
  } 
}

package tec;

/**
 * Implémentation d'une Montee Tetu.
 *
 * Lors de la montee dans un vehicule, prend une
 * place debout même si le vehicule est plein.
 */

class MonteeTetu extends PassagerAbstrait {

  /** 
   * Constructeur
   *
   * @param nom le nom du passager
   * @param destination le numéro d'arrêt où il descend
   * @param a le comportement à l'arret
   *
   */
  public MonteeTetu(String nom, int destination, ComportementArret a){
      super(nom, destination, a);
  }
    
  /**
   * Monte dans un véhicule donné.
   * Par choix d'implémentation, monte en position debout
   * même si le bus est plein
   * @param v le véhicule dans lequel le passager monte
   */
  final protected void choixPlaceMontee(Vehicule v) {
    v.monteeDemanderDebout(this);
  }
}

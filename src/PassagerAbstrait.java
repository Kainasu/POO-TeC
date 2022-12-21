package tec;
/**
 * PassagerAbstrait.
 *
 * Le comportement de ce passager est qu'il monte dans un
 * véhicule et ne change pas de position.
 */
abstract class PassagerAbstrait extends Passager implements Usager {
  private String nom ;
  private int destination ;
  private Position maPosition ;
  private ComportementArret arret;

  /** 
   * Constructeur
   *
   * @param nom le nom du passager
   * @param destination le numéro d'arrêt où il descend
   */
  public PassagerAbstrait(String nom , int destination, ComportementArret a){
    if (destination < 0)
      throw new IllegalArgumentException("destination invalide");
    this.maPosition = Position.creerPositionInitiale();
    this.nom = nom ;
    this.destination = destination ;
    this.arret = a;
  }

  /**
   * Accesseur du nom du passager.
   *
   * @return son nom
   */
  String nom(){
    return this.nom;
  }

  /**
   * Accesseur de la destination du passager.
   *
   * @return sa destination
   */
  final protected int destination() {
    return this.destination;
  }
  
  /**
   * Mutateur de la position.
   * Prend une position assise.
   */
  void changerEnAssis(){
    this.maPosition = this.maPosition.assis();
  }

  /**
   * Mutateur de la position.
   * Prend une position debout.
   */
  void changerEnDebout(){
    this.maPosition = this.maPosition.debout();
  }

  /**
   * Mutateur de la position.
   * Prend une position dehors.
   */
  void changerEnDehors(){
    this.maPosition = this.maPosition.dehors();
  }

  /**
   * Ma position est-elle assise ?
   *
   * @return vrai si elle l'est
   */
  boolean estAssis(){
    return this.maPosition.estAssis();
  }

  /**
   * Ma position est-elle debout ?
   *
   * @return vrai si elle l'est
   */
  boolean estDebout(){
    return this.maPosition.estDebout();
  }

  /**
   * Ma position est-elle dehors ?
   *
   * @return vrai si elle l'est
   */
  boolean estDehors(){
    return this.maPosition.estDehors();
  }

  /**
   * Monte dans un véhicule donné.
   * Par choix d'implémentation, la position assise est préférée.
   *
   * @param v le véhicule dans lequel le passager monte
   */
  
  public final void monterDans(Transport t) throws TecException {
    
    Vehicule v = (Vehicule) t;
    if (!(v instanceof Vehicule))
      throw new TecException("Conversion de type échouée");
    
    try {
      if (!this.estDehors())
	throw new IllegalStateException("Passager deja dans bus");
    } catch (IllegalStateException e) {
      throw new TecException(e);
    }
    choixPlaceMontee(v);
  }

  /**
   * Vérifie le traitement à faire lors d'un nouvel arrêt.
   *
   * @param v le véhicule dans lequel le passager est monté
   * @param numeroArret le nouvel arrêt
   */
  final void nouvelArret(Vehicule v, int numeroArret) {
    if (numeroArret == this.destination) {
      v.arretDemanderSortie(this);
    } else {
      choixPlaceArret(v, numeroArret);
    }
  }

  abstract protected void choixPlaceMontee(Vehicule v);

  protected void choixPlaceArret(Vehicule v, int numeroArret)
  {
    arret.choixPlaceArret(v, numeroArret, this);
  }
  
  public String toString(){
    String nom = null;
    if ( this.estAssis())
    {
      nom = "assis";
    }
    else 
    {
      if ( this.estDebout())
      {
        nom = "debout";
      }
      else 
      {
        if ( this.estDehors())
        {
          nom = "endehors";
        }
      }
    }
    return this.nom +" " + "<"+ nom +">";
  }

}

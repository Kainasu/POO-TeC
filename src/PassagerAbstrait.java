package tec;
/**
 * Implémentation d'un Passager Standard.
 *
 * Le comportement de ce passager est qu'il monte dans un
 * véhicule et ne change pas de position.
 */
abstract class PassagerAbstrait implements Passager, Usager{
  private String nom ;
  private int destination ;
  private Position maPosition ;
  protected ComportementArret arret;
  
  /** 
   * Constructeur
   *
   * @param nom le nom du passager
   * @param destination le numéro d'arrêt où il descend
   */
  protected PassagerAbstrait(String nom , int destination, ComportementArret a){
    maPosition = Position.creerPositionInitiale();
    this.nom = nom ;
    this.destination = destination ;
    this.arret = a;
  }

  /**
   * Accesseur du nom du passager.
   *
   * @return son nom
   */
  public String nom(){
    return this.nom;
  }

  protected abstract void choixPlaceMontee(Vehicule v);

  final public int destination()
  {
    return this.destination;
  }

  /**
   * Mutateur de la position.
   * Prend une position assise.
   */
  public void changerEnAssis(){
    this.maPosition = this.maPosition.assis();
  }

  /**
   * Mutateur de la position.
   * Prend une position debout.
   */
  public void changerEnDebout(){
    this.maPosition = this.maPosition.debout();
  }

  /**
   * Mutateur de la position.
   * Prend une position dehors.
   */
  public void changerEnDehors(){
    this.maPosition = this.maPosition.dehors();
  }

  /**
   * Ma position est-elle assise ?
   *
   * @return vrai si elle l'est
   */
  public boolean estAssis(){
    return this.maPosition.estAssis();
  }

  /**
   * Ma position est-elle debout ?
   *
   * @return vrai si elle l'est
   */
  public boolean estDebout(){
    return this.maPosition.estDebout();
  }

  /**
   * Ma position est-elle dehors ?
   *
   * @return vrai si elle l'est
   */
  public boolean estDehors(){
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
    
    if (!this.estDehors())
      throw new IllegalStateException("Passager deja dans bus");
    
    choixPlaceMontee(v);
  }

  /**
   * Vérifie le traitement à faire lors d'un nouvel arrêt.
   *
   * @param v le véhicule dans lequel le passager est monté
   * @param numeroArret le nouvel arrêt
   */
  final public void nouvelArret(Vehicule v, int numeroArret){
    if(this.destination() == numeroArret)
    {
      v.arretDemanderSortie(this);
    } else {
      choixPlaceArret(v, numeroArret);
    }
  }

  protected void choixPlaceArret(Vehicule v, int numeroArret) {
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

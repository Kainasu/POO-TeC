package tec;

public class PassagerGreffon implements Usager, Passager{
  private Passager p;
  private Greffon g; 

  public PassagerGreffon(Usager p){
    this.p = (Passager) p;
    this.g = null;
  }
  
  public PassagerGreffon(Usager p, Transport g){
    this.p = (Passager) p;
    this.g = (Greffon) g;
  }

  public void monterDans(Transport t) throws TecException{
    if (!(t instanceof Greffon))
      throw new TecException();
    this.g = (Greffon) t;
    ((Usager) p).monterDans(t);
  }

  public String nom(){
    return p.nom();
  }
  /**
   * Le passager est-il en dehors d'un véhicule ?
   * @return vrai si la position du passager est dehors.
   */
  public boolean estDehors(){
    return p.estDehors();
  }
  
  /**
   * Le passager est-il assis dans un véhicule ?
   * @return vrai si la position du passager est assis.
   */
  public boolean estAssis(){
    return p.estAssis();
  }
  
  /**
   * Le passager est-il debout dans un véhicule?
   * @return vrai si la position du passager est debout.
   */
  public boolean estDebout(){
    return p.estDebout();
  }
  
  /**
   * Change la position du passager en dehors.
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnDehors(){
    p.changerEnDehors();
  }
  
  /**
   * Change la position du passager en assis. 
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnAssis(){
    p.changerEnAssis();    
  }
  
  /**
   * Change la position du passager en debout.
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnDebout(){
    p.changerEnDebout();
  }

  /**
   * Cette méthode réalise le caractère à un arrêt du passager. 
   * Elle est appelée par le véhicule dans lequel est monté le passager. 
   *
   * @param v le vehicule dans lequel se trouve le passager.
   * @param numeroArret numéro de l'arrêt courant.
   */
  public void nouvelArret(Vehicule v, int numeroArret){    
    if(p.destination() == numeroArret) g.arretDemanderSortie(this);
    else p.nouvelArret(g, numeroArret);
  }
    

  public int destination(){
    return p.destination();
  }

  public String toString(){
    String nom = null;
    if ( p.estAssis())
      {
	nom = "assis";
      }
    else 
      {
	if ( p.estDebout())
      {
        nom = "debout";
      }
	else 
      {
        if ( p.estDehors())
	  {
	    nom = "endehors";
	  }
      }
      }
    return nom() +" " + "<"+ nom +">";
  }
  
  
}

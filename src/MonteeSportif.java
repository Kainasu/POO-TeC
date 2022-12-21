package tec;

class MonteeSportif extends PassagerAbstrait{

  public MonteeSportif(String nom , int destination, ComportementArret a){
    super(nom, destination, a);
  }
  
  final protected void choixPlaceMontee(Vehicule v){
    if (v.aPlaceDebout())
      v.monteeDemanderDebout(this);
  }
}

package tec;

class ArretPoli implements ComportementArret{
  
  final public void choixPlaceArret(Vehicule v, int numeroArret, Passager u)
    {
      if (u.estAssis() && !v.aPlaceAssise())
        v.arretDemanderDebout(u);
    }	
}

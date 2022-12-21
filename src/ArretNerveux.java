package tec;

class ArretNerveux implements ComportementArret{
  
  final public void choixPlaceArret(Vehicule v, int numeroArret, Passager u)
    {
      if (u.estDebout() && v.aPlaceAssise())
        v.arretDemanderAssis(u);
      else if (u.estAssis() && v.aPlaceDebout())
        v.arretDemanderDebout(u);
    }	
}

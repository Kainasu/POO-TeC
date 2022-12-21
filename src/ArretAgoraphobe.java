package tec;

class ArretAgoraphobe implements ComportementArret{
  
  final public void choixPlaceArret(Vehicule v, int numeroArret, Passager u)
    {
      if (!v.aPlaceAssise() || !v.aPlaceDebout())
        v.arretDemanderSortie(u);
    }	
}

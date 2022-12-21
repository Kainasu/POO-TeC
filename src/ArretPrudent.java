package tec;

class ArretPrudent implements ComportementArret{
  
  final public void choixPlaceArret(Vehicule v, int numeroArret, Passager u)
    {
      if (numeroArret == u.destination() - 3){
        v.arretDemanderDebout(u);
      }
      else
      {
        if (numeroArret <= u.destination() - 5){
          v.arretDemanderAssis(u);
        }
      }
    }	
}

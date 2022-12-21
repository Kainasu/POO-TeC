package tec;

class TestArretCalme implements TestComportementArret {

  public void testChoixPlaceArret(PassagerAbstrait p, FauxVehicule faux){
    p.nouvelArret(faux, 1);
    assert 0 == faux.logs.size() : "pas a destination";
  }
  
  String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() -1);
  }
}

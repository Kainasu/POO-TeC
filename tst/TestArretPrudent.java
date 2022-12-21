package tec;

class TestArretPrudent implements TestComportementArret {

  public void testChoixPlaceArret(PassagerAbstrait p, FauxVehicule faux){

    p.nouvelArret(faux,1);
    assert 0 == faux.logs.size() : "pas a destination";

    p.changerEnAssis();
    p.nouvelArret(faux,2);
    assert "arretDemanderDebout" == getLastLog(faux) : "debout";    

    p.changerEnDebout();
    p.nouvelArret(faux,3);
    assert 1 == faux.logs.size() : "pas a destination";
  }

  String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() -1);
  }
}

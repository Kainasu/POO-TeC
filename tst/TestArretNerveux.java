package tec;

class TestArretNerveux implements TestComportementArret {

  public void testChoixPlaceArret(PassagerAbstrait p, FauxVehicule faux){

    p.changerEnDebout();
    p.nouvelArret(faux, 2);    
    assert "arretDemanderAssis" == getLastLog(faux) : "assis";

    p.changerEnAssis();
    p.nouvelArret(faux, 3);    
    assert "arretDemanderDebout" == getLastLog(faux) : "debout";
    
  }
  
  String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() -1);
  }
}

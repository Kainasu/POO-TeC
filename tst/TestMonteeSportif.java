package tec;

abstract class TestMonteeSportif extends TestPassagerAbstrait {

  TestMonteeSportif(TestComportementArret tca) {
    super(tca);
  }

  public void testChoixPlaceMonteeVehiculeVide(FauxVehicule faux) {
    assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    
  }
    
  public void testChoixPlaceMonteeDeboutSeulement(FauxVehicule faux) {      
    assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    
  }

  public void testChoixPlaceMonteeAssisSeulement(FauxVehicule faux){
    assert 0 == faux.logs.size() : "dehors";
  }

}


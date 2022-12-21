package tec;

abstract class TestMonteeFatigue extends TestPassagerAbstrait {

  TestMonteeFatigue(TestComportementArret tca) {
    super(tca);
  }

  public void testChoixPlaceMonteeVehiculeVide(FauxVehicule faux) {
    assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
  }
    
  public void testChoixPlaceMonteeDeboutSeulement(FauxVehicule faux) {
    assert 0 == faux.logs.size() : "dehors"; 
  }

  public void testChoixPlaceMonteeAssisSeulement(FauxVehicule faux) {
    assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
  }

}

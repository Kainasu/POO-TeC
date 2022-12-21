package tec;

abstract class TestMonteeRepos extends TestPassagerAbstrait {

  TestMonteeRepos(TestComportementArret tca) {
    super(tca);
  }
   
    public void testChoixPlaceMonteeVehiculeVide(FauxVehicule faux) {
      assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
    }
    
    public void testChoixPlaceMonteeDeboutSeulement(FauxVehicule faux) {      
      assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    
    }

    public void testChoixPlaceMonteeAssisSeulement(FauxVehicule faux) {
      assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
    }
  
}

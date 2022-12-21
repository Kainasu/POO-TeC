package tec;

class TestPassagerStresse extends TestMonteeFatigue {

  TestPassagerStresse() {
    super(new TestArretPrudent());
  }
 
  protected PassagerAbstrait creerPassager(String nom, int destination){      
    return new PassagerStresse(nom, destination);
  }       
}


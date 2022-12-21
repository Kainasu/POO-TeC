package tec;

class TestPassagerIndecis extends TestMonteeSportif {

  TestPassagerIndecis() {
    super(new TestArretNerveux());
  }
    
  protected PassagerAbstrait creerPassager(String nom, int destination){
    return new PassagerIndecis(nom, destination);
  }
}


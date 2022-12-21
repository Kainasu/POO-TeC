package tec;

class TestPassagerStandard extends TestMonteeRepos {

  TestPassagerStandard() {
    super(new TestArretCalme());
  }
    
  protected PassagerAbstrait creerPassager(String nom, int destination){
    return new PassagerStandard(nom, destination);
  }
}


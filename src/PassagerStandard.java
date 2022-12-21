package tec;

class PassagerStandard extends MonteeRepos
{
  public PassagerStandard(String nom , int destination){
    super(nom, destination, new ArretCalme());
  }

}

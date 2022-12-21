package tec;

class PassagerStresse extends MonteeFatigue
{
  public PassagerStresse(String nom , int destination){
    super(nom, destination, new ArretPrudent());
  }
}

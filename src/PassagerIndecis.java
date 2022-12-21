package tec;

class PassagerIndecis extends MonteeSportif
{
  public PassagerIndecis(String nom , int destination){
    super(nom, destination, new ArretNerveux());
  }
}

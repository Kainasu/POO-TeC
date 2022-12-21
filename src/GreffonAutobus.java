package tec;
import log.Collecte;

public class GreffonAutobus extends Autobus {

  private Collecte collecte;

   /** 
   * Constructeur
   *
   * @param nbPlaceAssise limite maximale de la Jauge assis
   * @param nbPlaceDebout limite maximale de la Jauge debout
   * @param c le type de service de collecte
   */
  public GreffonAutobus(int  nbPlaceAssise, int nbPlaceDebout, Collecte c){
    super(nbPlaceAssise, nbPlaceDebout);
    this.collecte = c;
  }
  
  @Override
  public void allerArretSuivant(){
    super.allerArretSuivant();
    collecte.changerArret(this.numeroArret()-1);
  }

  @Override
  void monteeDemanderAssis(Passager p){
    super.monteeDemanderAssis(p);
    collecte.uneEntree();
    System.out.println(p.nom() + " monte à l'arret " + super.numeroArret() + " sur une place assise.");
  }

  @Override
  void monteeDemanderDebout(Passager p){
    super.monteeDemanderDebout(p);
    collecte.uneEntree();
    System.out.println(p.nom() + " monte à l'arret " + super.numeroArret() + " sur une place debout.");
  }

  @Override
  void arretDemanderSortie(Passager p){
    super.arretDemanderSortie(p);
    collecte.uneSortie();
    System.out.println(p.nom() + " descend à l'arret " + (super.numeroArret()));
  }

  public void terminus() {
    collecte.changerArret(super.numeroArret());
  }

  
  @Override
  public String toString(){
    return collecte.toString();
  }
}

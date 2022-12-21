package tec;
import log.Collecte;

public class Greffon implements Transport, Vehicule {

  private Collecte collecte;
  private Transport transport;
  private int numeroArret;

  /** 
   * Constructeur
   *
   */
  public Greffon(Transport t, Collecte c){
    this.transport = t;
    this.collecte = c;
    this.numeroArret = 0;
  }
  
  public void allerArretSuivant() {
    transport.allerArretSuivant();
    collecte.changerArret(numeroArret);
    numeroArret++;
  }

  public boolean aPlaceAssise() { return ((Vehicule)transport).aPlaceAssise(); }

  public boolean aPlaceDebout() { return ((Vehicule)transport).aPlaceDebout(); }

  public void monteeDemanderAssis(Passager p) {
    ((Vehicule)transport).monteeDemanderAssis(new PassagerGreffon((Usager) p, this));
    collecte.uneEntree();
    System.out.println(p.nom() + " monte à l'arret " + numeroArret + " sur une place assise.");
  }

  public void monteeDemanderDebout(Passager p) {
    ((Vehicule)transport).monteeDemanderDebout(new PassagerGreffon((Usager) p, this));
    collecte.uneEntree();
    System.out.println(p.nom() + " monte à l'arret " + numeroArret + " sur une place debout.");
  }

  public void arretDemanderDebout(Passager p) {
    ((Vehicule)transport).arretDemanderDebout(p);
  }

  public void arretDemanderAssis(Passager p) {
    ((Vehicule)transport).arretDemanderAssis(p);
  }

  public void arretDemanderSortie(Passager p) {
    ((Vehicule)transport).arretDemanderSortie(p);
    collecte.uneSortie();
    System.out.println(p.nom() + " descend à l'arret " + (numeroArret+1));
  }


  public void terminus() {
    collecte.changerArret(numeroArret);
  }
  
  @Override
  public String toString(){
    return collecte.toString();
  }
}

package tec;

/** 
 * Implémentation d'un autobus.
 *
 * À travers l'interface Véhicule, un autobus doit savoir
 * gérer une liste de Passager ainsi que l'avancement de son
 * trajet.
 */
public class Autobus implements Transport, Vehicule {

  private int numeroArret;
  private final Jauge debout;
  private final Jauge assis;
  private Passager[] passagersDebout;
  private Passager[] passagersAssis;
  
  /** 
   * Constructeur
   *
   * @param nbPlaceAssise limite maximale de la Jauge assis
   * @param nbPlaceDebout limite maximale de la Jauge debout
   */
  public Autobus(int  nbPlaceAssise, int nbPlaceDebout){
    debout = new Jauge(nbPlaceDebout, 0);
    assis = new Jauge(nbPlaceAssise,0);
    numeroArret = 0;
    passagersAssis = new Passager[nbPlaceAssise];
    passagersDebout = new Passager[nbPlaceDebout];

  }

  /**
   * Cherche dans un tableau de passagers non trié
   * un emplacement vide.
   *
   * @param tabP le tableau a parcourir
   * @return l'index de l'emplacement vide, sinon -1
   */
  private int chercherEmplacementVide(Passager[] tabP){
    for(int k=0; k<tabP.length; k++){
      if (tabP[k] == null)
        return k;
    }
    return -1;
  }

  /**
   * Cherche un emplacement vide spécifiquement
   * dans les places assises.
   *
   * @return l'index de l'emplacement vide, sinon -1
   */
  private int chercherEmplacementVideAssis(){
    return chercherEmplacementVide(passagersAssis);
  }

  /**
   * Cherche un emplacement vide spécifiquement
   * dans les places debouts.
   *
   * @return l'index de l'emplacement vide, sinon -1
   */
  private int chercherEmplacementVideDebout(){
    return chercherEmplacementVide(passagersDebout);
  }

  /**
   * Cherche un passager spécifique dans un tableau donné.
   *
   * @param tabP le tableau à parcourir
   * @param p    le passager à chercher
   * @return l'index de l'emplacement trouvé, sinon -1
   */
  private int chercherPassager(Passager[] tabP, Passager p){
    for (int k=0; k<tabP.length; k++){
      if (tabP[k] == p)
        return k;
    }
    return -1;
  }

  /**
   * Cherche un passager spécifique dans les places assises.
   *
   * @param p le passager à chercher
   * @return l'index de l'emplacement trouvé, sinon -1
   */
  private int chercherPassagerAssis(Passager p){
    return chercherPassager(passagersAssis,p);
  }

  /**
   * Cherche un passager spécifique dans les places debouts.
   *
   * @param p le passager à chercher
   * @return l'index de l'emplacement trouvé, sinon -1
   */
  private int chercherPassagerDebout(Passager p){
    return chercherPassager(passagersDebout,p);
  }

  /**
   * Gère la modification des passagers
   * d'un tableau donné lors d'un nouvel arrêt.
   *
   * @param tabP le tableau de passager
   */
  private void nouvelArretPassager(Passager[] tabP){
    for (int k=0; k<tabP.length; k++){
      if (tabP[k] != null)
        tabP[k].nouvelArret(this, numeroArret);
    }
  }
  
  /**
   * Gère la modification de tous les passagers
   * lors d'un nouvel arrêt.
   */    
  public void allerArretSuivant(){
    numeroArret ++;
    nouvelArretPassager(passagersAssis);
    nouvelArretPassager(passagersDebout);
  }

  /**
   * Reste-t-il des places assises ?
   *
   * @return vrai s'il en reste
   */
  public boolean aPlaceAssise(){
    return assis.estVert();
  }

  /**
   * Reste-t-il des places debouts ?
   *
   * @return vrai s'il en reste
   */
  public boolean aPlaceDebout(){
    return debout.estVert();
  }

  /**
   * Place un passager montant à une place assise.
   *
   * @param p le passager montant
   */
  public void monteeDemanderAssis(Passager p){
    assis.incrementer();
    int place = chercherEmplacementVideAssis();
    passagersAssis[place] = p;
    p.changerEnAssis();
  }
        
  /**
   * Place un passager montant à une place debout.
   *
   * @param p le passager montant
   */    
  public void monteeDemanderDebout(Passager p){
    debout.incrementer();
    int place = chercherEmplacementVideDebout();
    passagersDebout[place] = p;
    p.changerEnDebout();
  }

  /**
   * Donne une place debout à un passager assis.
   *
   * @param p le passager changeant
   */
  public void arretDemanderDebout(Passager p){
    assis.decrementer();
    debout.incrementer();
    p.changerEnDebout();
  }

  /**
   * Donne une place assise à un passager debout.
   *
   * @param p le passager changeant
   */
  public void arretDemanderAssis(Passager p){
    debout.decrementer();
    assis.incrementer();
    p.changerEnAssis();

  }

  /**
   * Sors un passager debout.
   *
   * @param p le passager sortant
   */
  private void passagerDeboutSort(Passager p){
    int position = chercherPassagerDebout(p);
    if (position != -1){
      debout.decrementer();
      passagersDebout[position] = null;
      p.changerEnDehors();
    }
  }

  /**
   * Sors un passager assis.
   *
   * @param p le passager sortant
   */
  private void passagerAssisSort(Passager p){
    int position = chercherPassagerAssis(p);
    if (position != -1){
      assis.decrementer();
      passagersAssis[position] = null;
      p.changerEnDehors();
    }
  }
    
  /**
   * Sors un passager.
   *
   * @param p le passager sortant
   */
  public void arretDemanderSortie(Passager p)
    {
      if (p.estDebout())
      {
        passagerDeboutSort(p);
      }
      else
      {
        passagerAssisSort(p);
      }
    }

  
  public String toString(){
    String arret = "[arret " + numeroArret + "]";
    String nAssis = "assis" + assis.toString();
    String nDebout = "debout" + debout.toString();
    return  arret + " " + nAssis + " " + nDebout;
  }
}

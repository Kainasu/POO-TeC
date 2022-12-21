package log;

/**
 * Cette interface spécifie les méthodes du service de collecte 
 * permettant d'obtenir, à chaque arrêt, le nombre de passagers
 * entrés et sortis et le numéro d'arrêt.
 */ 

abstract public class Collecte{

  private int nbEntre;
  private int nbSortiPrev;
  private int nbSortiNext;

  public Collecte(){
    nbEntre = 0;
    nbSortiPrev = 0;
    nbSortiNext = 0;

  }
  /**
   * Indique l'entrée d'un passager dans le transport
   */
  public void uneEntree(){
    nbEntre++;
  }

  /**
   * Indique la sortie d'un passager dans le transport
   */
  public void uneSortie(){
    nbSortiNext++;
  }

  int getnbEntre(){
    return nbEntre;
  }
 
  int getnbSortiPrev(){
    return nbSortiPrev;
  }
  
  int getnbSortiNext(){
    return nbSortiNext;
  }
  
  void setnbEntre(int nb){
    nbEntre = nb;
  }

   void setnbSortiPrev(int nb){
    nbSortiPrev = nb;
  }

   void setnbSortiNext(int nb){
    nbSortiNext = nb;
   }
  
  /**
   * Indique le changement d'un arret
   */
  final public void changerArret(Object arret){    
    ecrireDans(nbEntre, nbSortiPrev, arret);
    setnbSortiPrev(nbSortiNext);
    setnbSortiNext(0);
    setnbEntre(0);
  }

  abstract void ecrireDans(int entre, int sorti, Object arret);
}


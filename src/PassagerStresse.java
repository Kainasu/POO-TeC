package tec;
/**
 * Implémentation d'un Passager Stressé.
 *
 * Le comportement de ce passager est qu'il monte dans un
 * véhicule et demande une place debout 3 arrêts avant
 * sa destination.
 */
public class PassagerStresse extends MonteeFatigue {

  /** 
   * Constructeur
   *
   * @param nom le nom du passager
   * @param destination le numéro d'arrêt où il descend
   */
  public PassagerStresse(String nom , int destination){
    super(nom, destination, new ArretPrudent());
  }
  
  
}

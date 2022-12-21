package tec;
/**
 * Implémentation d'un Passager Standard.
 *
 * Le comportement de ce passager est qu'il monte dans un
 * véhicule et ne change pas de position.
 */
public class PassagerStandard extends MonteeRepos {

  /** 
   * Constructeur
   *
   * @param nom le nom du passager
   * @param destination le numéro d'arrêt où il descend
   */
  public PassagerStandard(String nom , int destination){
    super(nom, destination, new ArretCalme());
  }

}

package tec;

interface TestComportementArret {

  /**
   * Comportement du choix de la place
   * lors de l'arret d'un véhicule.
   * À définir dans les classes dérivées.
   *
   * @param p le passager en question
   * @param faux le véhicule prenant le passager à bord
   */
  public void testChoixPlaceArret(PassagerAbstrait p, FauxVehicule faux);
}

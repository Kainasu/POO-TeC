package tec;

abstract class TestPassagerAbstrait {

  protected TestComportementArret arret;

  TestPassagerAbstrait(TestComportementArret tca) {
    this.arret = tca;
  }
  
  //********************************************************
  /** Etat apres instanciation
   *  Un seul cas 
   */  
  public void testInstanciation() {
    PassagerAbstrait p = creerPassager("xxx", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  /** Gestion des changement d'état.
   * 
   *  Changer Debout puis Dehors puis assis. 
   */
  public void testGestionEtat() {
    PassagerAbstrait p = creerPassager("yyy", 3);

    p.changerEnDebout();
    assert false == p.estAssis();
    assert true == p.estDebout();
    assert false == p.estDehors();

    p.changerEnDehors();
    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();

    p.changerEnAssis();
    assert true == p.estAssis();
    assert false == p.estDebout();
    assert false == p.estDehors();
  }  
 
  /** Interaction a la montee
   *  Quatre cas
   *   - des places assises et debout
   *   - pas de place assise
   *   - pas de place debout
   *   - aucune place. 
   */
  public void testInteractionMontee() throws TecException {

    PassagerAbstrait p = creerPassager("yyy", 5);
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    p.monterDans(faux);
      
    testChoixPlaceMonteeVehiculeVide(faux);

    faux = new FauxVehicule(FauxVehicule.DEBOUT);
    p.monterDans(faux);

    testChoixPlaceMonteeDeboutSeulement(faux);

    faux = new FauxVehicule(FauxVehicule.ASSIS);
    p.monterDans(faux);

    testChoixPlaceMonteeAssisSeulement(faux);
    
    faux = new FauxVehicule(FauxVehicule.PLEIN);
    p.monterDans(faux);
	
    assert 0 == faux.logs.size() : "pas de place";
  }

  /**
   * Comportement du choix de la place
   * lors de la montée quand le véhicule
   * est vide. À définir dans les classes dérivées.
   *
   * @param faux le véhicule prenant le passager à bord
   */
  abstract public void testChoixPlaceMonteeVehiculeVide(FauxVehicule faux);

  /**
   * Comportement du choix de la place
   * lors de la montée quand le véhicule
   * n'a que des places debouts.
   * À définir dans les classes dérivées.
   *
   * @param faux le véhicule prenant le passager à bord
   */
  abstract public void testChoixPlaceMonteeDeboutSeulement(FauxVehicule faux);

  /**
   * Comportement du choix de la place
   * lors de la montée quand le véhicule
   * n'a que des places assises.
   * À définir dans les classes dérivées.
   *
   * @param faux le véhicule prenant le passager à bord
   */
  abstract public void testChoixPlaceMonteeAssisSeulement(FauxVehicule faux);

  /** Interaction a un arret
   *  Deux cas
   *   - numero d'arret < a la destination
   *   - numero d'arret >= a la destination 
   */
  public void testInteractionArret() {
    PassagerAbstrait p = creerPassager("yyy", 5);
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    
    arret.testChoixPlaceArret(p, faux);

    p.nouvelArret(faux, 5);
    assert "arretDemanderSortie" == getLastLog(faux) : "destination";

    
  }



  /**
   * Création d'un passager utile aux tests.
   * À définir dans les classes dérivées pour
   * prendre en compte leurs comportements
   * spécifiques pour la montée et l'arrêt.
   *
   * @param nom le nom du passager
   * @param destination le numero de son arrêt
   */
  abstract protected PassagerAbstrait creerPassager(String nom, int destination);
    
  protected String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() -1);
  }
}

package tec;

class TestPassagerStresse extends TestMonteeFatigue {

  TestPassagerStresse() {
    super(new TestArretPrudent());
  }
  
  public static void main (String[] args) throws TecException {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;
    new TestPassagerStresse().testInstanciation();

    //********* Verifier changement d'etat **************
    System.out.print('.'); nbTest++;
    new TestPassagerStresse().testGestionEtat();

    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestPassagerStresse().testInteractionMontee();

    System.out.print('.'); nbTest++;
    new TestPassagerStresse().testInteractionArret();

    System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStresse"); 
  }

  
  protected PassagerAbstrait creerPassager(String nom, int destination){      
    return new PassagerStresse(nom, destination);
  }
       
}


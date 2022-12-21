package tec;

class TestPassagerIndecis extends TestMonteeSportif {

  TestPassagerIndecis() {
    super(new TestArretNerveux());
  }
  
  public static void main (String[] args) throws TecException{
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;
    new TestPassagerIndecis().testInstanciation();

    //********* Verifier changement d'etat **************
    System.out.print('.'); nbTest++;
    new TestPassagerIndecis().testGestionEtat();

    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestPassagerIndecis().testInteractionMontee();

    System.out.print('.'); nbTest++;
    new TestPassagerIndecis().testInteractionArret();

    System.out.println("(" + nbTest + "):OK: " + "tec.PassagerIndecis"); 
  }

  
  protected PassagerAbstrait creerPassager(String nom, int destination){
    return new PassagerIndecis(nom, destination);
  }
   

}


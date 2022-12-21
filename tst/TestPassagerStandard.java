package tec;

class TestPassagerStandard extends TestMonteeRepos {

  TestPassagerStandard() {
    super(new TestArretCalme());
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
	new TestPassagerStandard().testInstanciation();

	//********* Verifier changement d'etat **************
	System.out.print('.'); nbTest++;
	new TestPassagerStandard().testGestionEtat();

	//********* Verifier les interactions  *************
	System.out.print('.'); nbTest++;
	new TestPassagerStandard().testInteractionMontee();

	System.out.print('.'); nbTest++;
	new TestPassagerStandard().testInteractionArret();

	System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStandard"); 
    }

  
    protected PassagerAbstrait creerPassager(String nom, int destination){
	return new PassagerStandard(nom, destination);
    }

}


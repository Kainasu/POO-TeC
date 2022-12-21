package tec;

class TestJauge {

  public void testDansIntervalle(){
    int max = 67899;
    int depart = 100;
    Jauge intervalle = new Jauge(max, depart);
    assert ! intervalle.estRouge() : "niveau >= max alors qu'on devait avoir niveau < max";
    assert intervalle.estVert() : "niveau devait appartenir à [0, max[";
  }

  public void testSuperieurIntervalle(){
    int max = 100;
    int depart = 101;
    Jauge intervalle = new Jauge(max, depart);
    assert intervalle.estRouge() : "niveau < max alors qu'on devait avoir niveau >= max";
    assert ! intervalle.estVert() : "niveau ne devait pas appartenir à [0, max[";
    intervalle.decrementer();
    assert intervalle.estRouge() : "niveau < max alors qu'on devait avoir niveau >= max";
    assert ! intervalle.estVert() : "niveau ne devait pas appartenir à [0, max[";	
  }

  public void testDepasserIntervalleDroite(){
    int max = 100;
    int depart = 99;
    Jauge intervalle = new Jauge(max, depart);
    assert ! intervalle.estRouge() : "niveau >= max alors qu'on devait avoir niveau < max";
    assert  intervalle.estVert() : "niveau devait appartenir à [0, max[";
    intervalle.incrementer();
    assert intervalle.estRouge() : "niveau < max alors qu'on devait avoir niveau >= max";
    assert ! intervalle.estVert() : "niveau ne devait pas appartenir à [0, max[";
  }

  public void testDepasserIntervalleGauche(){
    int max = 100;
    int depart = 0;
    Jauge intervalle = new Jauge(max, depart);
    assert ! intervalle.estRouge() : "niveau >= max alors qu'on devait avoir niveau < max";
    assert intervalle.estVert() : "niveau devait appartenir à [0, max[";
    intervalle.decrementer();
    assert ! intervalle.estRouge() : "niveau >= max alors qu'on devait avoir niveau < max";
    assert ! intervalle.estVert() : "niveau ne devait pas appartenir à [0, max[";
  }
    
  public void testNegatifIntervalle(){
    int max = 100;
    int depart = -1;
    Jauge intervalle = new Jauge(max, depart);
    assert ! intervalle.estRouge() : "niveau >= max alors qu'on devait avoir niveau < max";
    assert ! intervalle.estVert() : "niveau ne devait pas appartenir à [0, max[";
    intervalle.incrementer();
    assert intervalle.estVert() : "niveau devait appartenir à [0, max[";
    assert ! intervalle.estRouge() : "niveau >= max alors qu'on devait avoir niveau < max";
  }

  public void testCasLimite(){
    Jauge inverse = null;
    try{
      inverse = new Jauge(-42,10);
      assert false : "Exeption non levee";
    } catch(IllegalArgumentException e){
      System.err.println(e.getMessage());
    }

  }
    
  public static void main (String[] args){
	
    boolean estMisAssertion = false;
    assert estMisAssertion = true;
	
    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    System.out.print('.'); nbTest++;
    new TestJauge().testDansIntervalle();
    
    System.out.print('.'); nbTest++;
    new TestJauge().testSuperieurIntervalle();

    System.out.print('.'); nbTest++;
    new TestJauge().testNegatifIntervalle();

    System.out.print('.'); nbTest++;
    new TestJauge().testDepasserIntervalleDroite();

    System.out.print('.'); nbTest++;
    new TestJauge().testDepasserIntervalleGauche();


    System.out.println("(" + nbTest + "):OK: " + "tec.TestJauge");
  }
}

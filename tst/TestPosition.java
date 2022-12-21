package tec;

class TestPosition{


  public String errorMessage(Position pos){
    return "assis : " + pos.estAssis() + " debout : " + pos.estDebout() + " dehors : " + pos.estDehors();
            
  }
        
  public void testAssis(){
    Position p =  Position.creerPositionInitiale();
    Position posAssis = p.assis() ;
    assert posAssis.estAssis()   : this.errorMessage(posAssis);
    assert !posAssis.estDebout() : this.errorMessage(posAssis);
    assert !posAssis.estDehors() : this.errorMessage(posAssis);
    assert posAssis.estInterieur() : this.errorMessage(posAssis);
  }

  public void testDebout(){
    Position p =  Position.creerPositionInitiale();
    Position posDebout = p.debout() ;
    assert !posDebout.estAssis()   : this.errorMessage(posDebout);
    assert posDebout.estDebout() : this.errorMessage(posDebout);
    assert !posDebout.estDehors() : this.errorMessage(posDebout);
    assert posDebout.estInterieur() : this.errorMessage(posDebout);        
  }

  public void testDehors(){
    Position p =  Position.creerPositionInitiale();
    Position posDehors = p.dehors();
    assert !posDehors.estAssis()   : this.errorMessage(posDehors);
    assert !posDehors.estDebout() : this.errorMessage(posDehors);
    assert posDehors.estDehors() : this.errorMessage(posDehors);
    assert !posDehors.estInterieur(): this.errorMessage(posDehors);        
  }

  
  public static void main(String[] args){

        
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion){
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    System.out.print('.'); nbTest++;
    new TestPosition().testAssis();

    System.out.print('.'); nbTest++;
    new TestPosition().testDebout();

    System.out.print('.'); nbTest++;
    new TestPosition().testDehors();
    
        System.out.println("(" + nbTest + "):OK: " + "tec.TestPosition");
  }
}

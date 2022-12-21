package tec;
import java.lang.reflect.Method;

class LancerTests {

  static private void lancer(Class c) throws Exception{
    int nbTest = 0;
    Method[] methods = c.getMethods();
    for (Method m : methods){
      if (m.getName().contains("test") && m.getParameterCount() == 0){
	System.out.print('.'); nbTest++;
	m.invoke(c.newInstance(), new Object[0]);	
	}
    }
    System.out.print("(" + nbTest + "):OK:");
  }

  static public void main(String[] args) throws Exception{
    boolean estMisAssertion = false;
    assert estMisAssertion = true;
    
    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    for(int i = 0; i<args.length; i++){
      Class c = Class.forName(args[i]);
      lancer(c);
      System.out.print(args[i] + "\n");
    }
    return;
  }					     
}

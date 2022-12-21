package log;
import java.util.LinkedList;

public class CollecteMemoire extends Collecte {

  private class Data {
    private Object arret;
    private int entrees;
    private int sorties;
    
    private Data(int e, int s, Object a){
      entrees = e;
      sorties = s;
      arret = a;
    }
    final Object getArret(){
      return arret;
    }
    
    final int getEntrees(){
      return entrees;
    }
    
    final int getSorties(){
      return sorties;
    }
    
    public String toString(){
      return "[" + arret + ", " + entrees +", "+ sorties + "]";      
    }
    
   }

  
  private LinkedList<Data> logs;

  public CollecteMemoire(){
    super();
    logs = new LinkedList<Data>();
  }
   
  void ecrireDans(int entre, int sorti, Object arret){
    Data log = new Data(entre, sorti, arret);
    logs.add(log);
  }


  public String toString(){
    if (logs.size() == 0)
      return "";
    String arret = "\nArret " + logs.getLast().getArret();
    String nbEntree = "" + logs.getLast().getEntrees() + " entré(s)";
    String nbSortie = "" + logs.getLast().getSorties() + " sorti(s)";
    return arret + " : " + nbEntree + ", " + nbSortie + "\nMemoire: " + logs.toString();
  }
}

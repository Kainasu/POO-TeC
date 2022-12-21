package log;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CollecteFichier extends Collecte {
  
  private String nomFichier;

  
  public CollecteFichier(String nf) {
    super();
    nomFichier = nf;
  }

  void ecrireDans(int entre, int sorti, Object arret) {
    try{
      FileWriter fw = new FileWriter(nomFichier, true);
      PrintWriter pw = new PrintWriter(fw);

      pw.print("Arret " + arret);
      pw.print(", " + entre + " entré(s)");
      pw.println(", " + sorti + " sorti(s)");
      pw.flush();
      
      fw.close();
    } catch (IOException e){
      System.err.println(e.getMessage());
    }
  }
  
  public String toString() {
    return "";
  }
}

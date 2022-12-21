package tec;
import log.CollecteMemoire;
import log.CollecteFichier;

final public class FabriqueTec {

    private FabriqueTec() {

    }

    static public Usager fairePassagerStandard(String nom, int dest) {
        return new PassagerStandard(nom, dest);
    }
    static public Usager fairePassagerIndecis(String nom, int dest) {
        return new PassagerIndecis(nom, dest);
    }
    static public Usager fairePassagerStresse(String nom, int dest) {
        return new PassagerStresse(nom, dest);
    }
    
    static public Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout) {
        return new Autobus(nbPlaceAssise, nbPlaceDebout);
    }

      static public Transport faireAutobusGreffonMemoire(int nbPlaceAssise, int nbPlaceDebout) {
        return new Greffon(new Autobus(nbPlaceAssise, nbPlaceDebout), new CollecteMemoire());
    }

       static public Transport faireAutobusGreffonFichier(int nbPlaceAssise, int nbPlaceDebout) {
        return new Greffon(new Autobus(nbPlaceAssise, nbPlaceDebout), new CollecteFichier("log.txt"));
    }

  

}


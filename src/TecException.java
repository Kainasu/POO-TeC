package tec;

public class TecException extends Exception {
  public TecException(){
    super();
  }

  public TecException(String s){
    super(s);
  }

  public TecException(Throwable cause){
    super(cause);
  }
}

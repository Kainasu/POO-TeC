public class StringTest{
    public static void main(String args[]){

        char valeur[] = {'K', 'a', 'l', 'k', 'i'};
        String s1 = new String(valeur);
        String s2 = new String(valeur);
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == "Kalki");

        System.out.println(s3 == s4);
        System.out.println(s3 == "Kalki");
    
    }
}
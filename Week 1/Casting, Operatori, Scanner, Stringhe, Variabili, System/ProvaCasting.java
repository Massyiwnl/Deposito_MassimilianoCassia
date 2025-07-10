
public class ProvaCasting {
    public static void main(String[] args) {
        int myInt = 9;

        double myDouble = myInt; // casting automatico implicito: int to double

        System.out.println(myInt); //9
        System.out.println(myDouble); //9.0

        double myDouble2 = 9.78d;
        int myInt2 = (int) myDouble2; // casting esplicito: double to int

        System.out.println(myDouble2); //9.78
        System.out.println(myInt2); //9  
    }
}



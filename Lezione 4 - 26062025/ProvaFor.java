import java.util.Scanner;
public class ProvaFor{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    
        
        System.out.println("Inserisci un numero: "); 
        int numero = scanner.nextInt();

        System.out.println("Tabellina del " + numero + ":");
        // Ciclo for per stampare la tabellina del numero inserito
        for(int i = 1; i <= 10; i++){
            System.out.println(numero + " x " + i + " = " + (numero * i ));

        }
        
    }
}

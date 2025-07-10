import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDivisione2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserire un numero: ");
            int numero = scanner.nextInt();
            int risultato = ProvaEccezioniDivisione.divisioneUnChecked(numero, 0);
            System.out.println(risultato);
            //catch multiplo
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

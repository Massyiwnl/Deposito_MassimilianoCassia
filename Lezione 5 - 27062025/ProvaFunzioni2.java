public class ProvaFunzioni2 {
    int fattoriale(int n){
        if (n == 1) return 1; // caso base
        return n * fattoriale(n-1); // chiamata ricorsiva
    }
    
    public static void main(String[] args) {
        ProvaFunzioni2 pf = new ProvaFunzioni2(); // Creazione di un'istanza della classe
        int numero = 5; // Numero di cui calcolare il fattoriale
        int risultato = pf.fattoriale(numero); // Chiamata al metodo fattoriale
        System.out.println("Il fattoriale di " + numero + " è: " + risultato); // Stampa del risultato
    }
}

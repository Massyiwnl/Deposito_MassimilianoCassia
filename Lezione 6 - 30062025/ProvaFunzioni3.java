class UtilitaMatematica{ // Classe che contiene metodi statici e non statici per operazioni matematiche
    // Metodo statico per calcolare il quadrato di un numero
    static int quadrato(int num){
        return num * num; // Calcola il quadrato di un numero
    }
    // Metodo non statico per calcolare il cubo di un numero
    int cubo(int num){
        return num * num * num; // Calcola il cubo di un numero
    }
}

public class ProvaFunzioni3 {
    public static void main(String[] args) {
        //Nessun oggetto necessario per chiamare il metodo statico
        System.out.println(UtilitaMatematica.quadrato(5)); // Stampa il quadrato di 5

        UtilitaMatematica obj = new UtilitaMatematica(); // Crea un'istanza della classe UtilitaMatematica
        // Necessario un oggetto per chiamare il metodo non statico
        System.out.println(obj.cubo(5)); // Stampa il cubo di 5
    }
}

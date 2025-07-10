

public class ProvaArray {
    public static void main(String[] args) {
        int[] numero = new int[5];
        //Array di dimensioni 5

        int[] valori = {1, 2, 3, 4, 5};
        //inizializzazione diretta

        //faccio un esercizio per capire bene
        int[] numeri = new int[5];

        //riempimento dell'array con i numeri 1-5
        for(int i = 0; i < numeri.length; i++){
            numeri[i] = i + 1;
            //quindi qui stiamo riempiendo tutto l'array praticamente, poi dopo rileggiamo l'array per vedere step by step che c'è dentro
        }
        //stampa degli elementi dell'array
        System.out.println("Elementi dell'array:");
        for(int i = 0; i < numeri.length; i++){
            System.out.println(numeri[i] + " ");
        }

        //adesso provo le matrici

        //array 2D
        int[][] matrice = new int[3][3];

        //inizializzazione diretta
        int [][] matricePredefinita = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Elemento centrale: " + matricePredefinita[1][1]);
    

    //arrau multidimensionale, con una matrice 3x3

    int[][] matr = new int[3][3]; //dichiarazione matrice 3x3
    int val = 1;

    //riempimento della matrice con numeri progessivi
    for (int i = 0; i < matr.length; i++){
        for(int j = 0; j < matr[i].length; j++){
            matr[i][j] = val++;
         }
    }
    System.out.println("Matrice 3x3: ");
    for(int i = 0; i < matr.length; i++){
        for (int j = 0; j < matr[i].length; j++){
            System.out.println(matr[i][j] + "\t");
        }
        System.out.println();
    }

    }
    
}

public class ProvaCondizioni {
    public static void main(String[] args) {
        if (20 > 18){ // Condizione
            // Blocco di codice da eseguire se la condizione è vera
            System.out.println("20 è maggiore di 18");
        } 

        int x = 20; //provo con delle variabili
        int y = 18;
        if(x > y){ // Condizione
            // Blocco di codice da eseguire se la condizione è vera
            System.out.println("x è maggiore di y");
        }

        //provo il blocco else
        int time = 20;
        if (time < 18){// Condizione
            // Blocco di codice da eseguire se la condizione è vera
            System.out.println("Buongiorno");
        } else { // Blocco di codice da eseguire se la condizione è falsa   
            System.out.println("Buonasera");
        }

        //provo il blocco else if
        int time2 = 22;
        if(time2 < 10){ // Condizione
            // Blocco di codice da eseguire se la condizione è vera
            System.out.println("Buongiorno");
        } else if(time2 < 18){// Condizione alternativa
            // Blocco di codice da eseguire se la condizione alternativa è vera
            System.out.println("Buon pomeriggio");
        } else{// Condizione alternativa finale
            // Blocco di codice da eseguire se nessuna condizione precedente è vera
            System.out.println("Buonasera");
        }

        // faccio una cosa identica a quello con time = 20 ma con una condizione moderna
        //time = 20; già l'avevo scritto sopra 
        String result = (time < 18) ? "Buongiorno" : "Buonasera"; // Operatore ternario
        // Stampo il risultato
        // Se la condizione è vera, viene assegnato "Buongiorno",
        // altrimenti viene assegnato "Buonasera"
        // Questo è un modo compatto per scrivere un'istruzione if-else
        System.out.println(result);
    }
}

public class ProvaFunzioni {
    static void saluta(){
        System.out.println("Ciao, Java!");
    }
    static int somma(int a, int b){
        return a + b;
    }
    
    static void mostra(int numero){
        System.out.println("numero: " + (10 + numero));
    }

    static void mostra(String testo){
        System.out.println("Testo: " + testo);
    }

    public static void main(String[] args) {
        saluta(); //chiamata del metodo    
        System.out.println(somma(3,5));
        mostra(10);
        mostra("Ciao");
    }
}
  
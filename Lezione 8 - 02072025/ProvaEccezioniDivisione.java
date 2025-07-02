public class ProvaEccezioniDivisione {
    public static int divisioneChecked(int a, int b) throws Exception {//si mette throws Exception per indicare che il metodo può lanciare un'eccezione
        if (b == 0){
            //Unhandled exception -> checked
            throw new Exception();// Crea un'eccezione con new oggetto Exception
         }
        return a / b;
    }      

     public static int divisioneUnChecked(int a, int b)  { //si mette throws Exception per indicare che il metodo può lanciare un'eccezione
        //qui non si mette throws Exception perchè è un'eccezione non controllata (unchecked)
        //le unchecked non devono essere gestite, ma è consigliato farlo
        if (b == 0){
            throw new RuntimeException("Il secondo operando non può essere 0");// Crea un'eccezione con new oggetto Exception
        }
        return a / b;
    }

    public static int divisione3(int a, int b){
        try {
            return a/b;
        } catch (Exception e) {
            //al chiamante arrivano le eccezioni, ma non le gestisce
            //se non gestisci l'eccezione, il compilatore ti dice che non puoi usare il metodo
            //se gestisci l'eccezione, il compilatore ti dice che puoi usare il metodo
            //la unchecked è più snella, però molto più pericoloso.
            throw new RuntimeException("Il secondo operando non può essere zero", e); // Rilancia l'eccezione come RuntimeException
        }
    }
}
//la throw è come una return, ma lancia un'eccezione
//la throws è come una return, ma indica che il metodo può lanciare un'eccezione
//In esecuzione le due non cambiano, cambiano solo in compilazione
//la differenza tra checked e unchecked è che le checked devono essere gestite con try-catch o dichiarate con throws
//le unchecked non devono essere gestite, ma è consigliato farlo
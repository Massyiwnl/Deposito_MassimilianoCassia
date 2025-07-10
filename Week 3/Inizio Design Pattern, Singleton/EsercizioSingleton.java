/*
Design pattern ES Singleton
Progetta un logger centralizzato che possa essere usato da qualsiasi parte del
programma per scrivere messaggi di log su console. Il logger deve essere implementato
seguendo il pattern Singleton.

Requisiti:
Crea una classe Logger con:
    Un campo privato statico per contenere l’unica istanza (private static Logger istanza)
    Un costruttore privato
    Un metodo statico pubblico GetIstanza() che restituisce sempre la stessa istanza
    Un metodo ScriviMessaggio(string messaggio) che stampa il messaggio con data e ora


Nel Main:
    Richiama Logger.GetIstanza() da almeno due punti distinti del codice
    Usa ScriviMessaggio() per stampare messaggi diversi
    Dimostra che si tratta sempre della stessa istanza (es. confrontando i
    riferimenti)
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger2{
    private static Logger2 istance;

    private Logger2(){}

    public static Logger2 GetIstanza(){
         if (istance == null) {
            istance = new Logger2(); //creando la nuova istanza se non esiste
        }
        return istance;
    }

    public void ScriviMessaggio(String messaggio){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + now + "] " + messaggio);
    }
}

public class EsercizioSingleton {
    public static void main(String[] args) {
        // Ottengo l'istanza singleton
        Logger2 logger1 = Logger2.GetIstanza();
        Logger2 logger2 = Logger2.GetIstanza();

        // Chiamo il metodo DoSomething() su entrambe le variabili
        logger1.ScriviMessaggio("Ciaooooooooooooooo");
        logger2.ScriviMessaggio("Come stai?");

        if (logger1.equals(logger2)) {
            System.out.println("logger1 e logger2 sono la stessa istanza (SINGLETON funzionante)");
        } else {
            System.out.println("Qualcosa non va: istanze diverse!");
}
    }
}

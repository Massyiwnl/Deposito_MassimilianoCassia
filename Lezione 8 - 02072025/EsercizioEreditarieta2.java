/*
Esercizio: Gestione Semplice di un Hotel
Obiettivi: Applicare incapsulamento (attributi privati e getter/setter). Applicare ereditarietà (almeno una sottoclasse di una classe base). 
Usare l’overload (sovraccarico) di almeno un metodo. Usare almeno un metodo statico.

Traccia
Classe base Camera
    Attributi privati: numero (int), prezzo (float).
    Metodi getter/setter per tutti gli attributi.
    Metodo dettagli() che stampa info sulla camera.
    Overload di dettagli():
        Uno senza parametri: stampa tutto.
        Uno con parametro booleano conPrezzo: se true stampa anche il prezzo, altrimenti solo numero.

Sottoclasse Suite (estende Camera)
    Attributo privato: serviziExtra (String).
    Getter/setter per serviziExtra.
    Override di dettagli(): stampa anche i servizi extra.

Classe Hotel
    Attributo privato: nome (String).
    Attributo privato: lista di camere (ArrayList<Camera>).
    Metodo per aggiungere una camera.
    Metodo statico contaSuite(ArrayList<Camera> lista) che restituisce quante Suite ci sono nella lista.

Nel main:
Crea un hotel, aggiungi almeno 2 camere normali e 2 suite. 
Usa il metodo overload dettagli() in entrambe le forme.
Usa il metodo statico per contare quante suite ci sono.
Stampa l’output.
 */

//Obiettivi: Applicare incapsulamento (attributi privati e getter/setter). Applicare ereditarietà (almeno una sottoclasse di una classe base). Usare l’overload (sovraccarico) di almeno un metodo. Usare almeno un metodo statico.

//Classe base Camera
import java.util.ArrayList;

class Camera{
    private int numero;
    private float prezzo;

    public Camera (int numero, float prezzo){
        this.numero = numero;
        this.prezzo = prezzo;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public float getPrezzo(){
        return prezzo;
    }

    public void setPrezzo(float prezzo){
        this.prezzo = prezzo;
    }

    public void dettagli(){
        System.out.println("Camera numero: " + numero + ", Prezzo: $" + prezzo);
    }
    //overload del metodo dettagli() con parametro booleano
    public void dettagli(boolean conPrezzo){
        if(conPrezzo){
            System.out.println("Camera numero: " + numero + ", Prezzo: $" + prezzo);
        }else{
            System.out.println("Camera numero: " + numero);
        }
    }
}


class Suite extends Camera{
    private String serviziExtra;

    //costruttore
    public Suite(int numero, float prezzo, String serviziExtra){
        super(numero, prezzo); //chiama il costruttore della classe padre
        this.serviziExtra = serviziExtra;
    }

    //getter e setter per serviziExtra
    public String getServiziExtra(){
        return serviziExtra;
    }

    public void setServiziExtra(String serviziExtra){
        this.serviziExtra = serviziExtra;
    }

    //override del metodo dettagli()
    @Override
    public void dettagli(){
        System.out.println("Suite numero: " + getNumero() + 
                         ", Prezzo: €" + getPrezzo() + 
                         ", Servizi extra: " + serviziExtra);
    }

    //override del metodo dettagli() overloaded
    @Override
    public void dettagli(boolean conPrezzo){
        if(conPrezzo){
            System.out.println("Suite numero: " + getNumero() + 
                             ", Prezzo: €" + getPrezzo() + 
                             ", Servizi extra: " + serviziExtra);
        } else{
            System.out.println("Suite numero: " + getNumero() + 
                             ", Servizi extra: " + serviziExtra);
        }
    }
}

class Hotel{
    private String nome;
    private ArrayList<Camera> camere;

    //costruttore
    public Hotel(String nome){
        this.nome = nome;
        this.camere = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void aggiungiCamera(Camera camera){
        camere.add(camera);
        System.out.println("Camera aggiunta all'hotel " + nome);
    }

    //getter per la lista delle camere
    public ArrayList<Camera> getCamere(){
        return camere;
    }

    //metodo statico per contare le suite
    public static int contaSuite(ArrayList<Camera> lista){
        int contatore = 0;
        for(Camera camera : lista){
            if(camera instanceof Suite){ //L'operatore instanceof verifica se l’oggetto referenziato dalla variabile camera appartiene (è un’istanza) alla classe Suite, o a una sua sottoclasse. In pratica, serve a identificare se l’oggetto è effettivamente del tipo specificato (o di un tipo derivato).
                contatore++;
            }
        }
        return contatore;
    }
    public void stampaDettagliHotel() {
        System.out.println("\nDETTAGLI HOTEL: " + nome);
        for (Camera camera : camere) {
            camera.dettagli();
        }
    }
}

public class EsercizioEreditarieta2 {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA GESTIONE HOTEL ===\n");
        
        // Crea un hotel
        Hotel hotel = new Hotel("Grand Hotel Roma");
        
        // Crea camere normali
        Camera camera1 = new Camera(101, 120.50f);
        Camera camera2 = new Camera(102, 95.00f);
        
        // Crea suite
        Suite suite1 = new Suite(201, 250.00f, "Jacuzzi, Minibar, Vista mare");
        Suite suite2 = new Suite(202, 300.00f, "Terrazza privata, Servizio in camera 24h");
        
        // Aggiungi camere all'hotel
        hotel.aggiungiCamera(camera1);
        hotel.aggiungiCamera(camera2);
        hotel.aggiungiCamera(suite1);
        hotel.aggiungiCamera(suite2);
        
        // Stampa dettagli dell'hotel
        hotel.stampaDettagliHotel();
        
        // Test dell'overload del metodo dettagli()
        System.out.println("\n=== TEST OVERLOAD METODO DETTAGLI ===");
        System.out.println("Camera normale - dettagli() senza parametri:");
        camera1.dettagli();
        
        System.out.println("\nCamera normale - dettagli(false) senza prezzo:");
        camera1.dettagli(false);
        
        System.out.println("\nSuite - dettagli() senza parametri:");
        suite1.dettagli();
        
        System.out.println("\nSuite - dettagli(false) senza prezzo:");
        suite1.dettagli(false);
        
        // Usa il metodo statico per contare le suite
        int numeroSuite = Hotel.contaSuite(hotel.getCamere());
        System.out.println("\n=== STATISTICHE HOTEL ===");
        System.out.println("Numero totale di camere: " + hotel.getCamere().size());
        System.out.println("Numero di suite: " + numeroSuite);
        System.out.println("Numero di camere standard: " + (hotel.getCamere().size() - numeroSuite));
        
        // Test aggiuntivi per dimostrare le funzionalità
        System.out.println("\n=== TEST MODIFICA ATTRIBUTI ===");
        System.out.println("Modifica prezzo camera 101...");
        camera1.setPrezzo(130.00f);
        camera1.dettagli();
        
        System.out.println("\nModifica servizi extra suite 201...");
        suite1.setServiziExtra("Jacuzzi, Minibar, Vista mare, Colazione in camera");
        suite1.dettagli();
    }
}

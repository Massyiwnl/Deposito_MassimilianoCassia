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
import java.util.InputMismatchException;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("Grand Hotel Roma"); 

        int scelta;
        do {
            System.out.println("\n--- GESTIONE HOTEL ---");
            System.out.println("1. Aggiungi Camera");
            System.out.println("2. Aggiungi Suite");
            System.out.println("3. Stampa dettagli camere");
            System.out.println("4. Conta Suite");
            System.out.println("5. Modifica Prezzo Camera");
            System.out.println("6. Modifica Servizi Extra Suite");
            System.out.println("7. Esci");
            System.out.print("Scegli un'opzione: ");

            try {
                scelta = sc.nextInt();
                sc.nextLine(); // Consuma newline

                switch (scelta) {
                    case 1:
                        System.out.print("Numero camera: ");
                        int numCam = sc.nextInt();
                        System.out.print("Prezzo camera: ");
                        float prezzoCam = sc.nextFloat();
                        hotel.aggiungiCamera(new Camera(numCam, prezzoCam));
                        break;

                    case 2:
                        System.out.print("Numero suite: ");
                        int numSuite = sc.nextInt();
                        System.out.print("Prezzo suite: ");
                        float prezzoSuite = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("Servizi extra suite: ");
                        String serviziExtra = sc.nextLine();
                        hotel.aggiungiCamera(new Suite(numSuite, prezzoSuite, serviziExtra));
                        break;

                    case 3:
                        hotel.stampaDettagliHotel();
                        break;

                    case 4:
                        int totaleSuite = Hotel.contaSuite(hotel.getCamere());
                        System.out.println("Numero di suite presenti: " + totaleSuite);
                        break;

                    case 5:
                        System.out.print("Inserisci numero camera da modificare: ");
                        int modificaCameraInt = sc.nextInt();
                        System.out.print("Nuovo prezzo: ");
                        float nuovoPrezzo = sc.nextFloat();

                        boolean trovata = false;
                        for (Camera cm : hotel.getCamere()) {
                            if (cm.getNumero() == modificaCameraInt) {
                                cm.setPrezzo(nuovoPrezzo);
                                System.out.println("Prezzo modificato con successo!");
                                trovata = true;
                                break;
                            }
                        }
                        if (!trovata)
                            System.out.println("Camera non trovata!");
                        break;

                    case 6:
                        System.out.print("Inserisci numero suite da modificare: ");
                        int modificaSuiteInt= sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nuovi servizi extra: ");
                        String nuoviServizi = sc.nextLine();

                        trovata = false;
                        for (Camera cm : hotel.getCamere()) {
                            if (cm instanceof Suite && cm.getNumero() == modificaSuiteInt) {
                                ((Suite) cm).setServiziExtra(nuoviServizi); //la variabile cm, dichiarata come tipo Camera, viene temporaneamente convertita in tipo Suite attraverso 
                                                                            //il casting esplicito (Suite). Questo è necessario perché il metodo setServiziExtra() 
                                                                            //è definito solo nella classe Suite e non nella classe padre Camera
                                                                            //Questa operazione è sicura solo se prima si è verificato con instanceof che l'oggetto sia effettivamente una Suite, 
                                                                            //come avviene in questo caso
                                System.out.println("Servizi extra modificati con successo!");
                                trovata = true;
                                break;
                            }
                        }
                        if (!trovata)
                            System.out.println("Suite non trovata!");
                        break;

                    case 7:
                        System.out.println("Uscita dal programma.");
                        break;

                    default:
                        System.out.println("Opzione non valida. Riprova.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserire il tipo di dato corretto.");
                sc.nextLine(); // Consuma input errato
                scelta = 0; // Reimposta scelta per continuare il ciclo
            } catch (Exception e) {
                System.out.println("Errore generico: " + e.getMessage());
                sc.nextLine(); // Consuma eventuale input errato
                scelta = 0;
            }

        } while (scelta != 7);

        sc.close();
    }
}

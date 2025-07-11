/*
Design pattern ES Adapter

Esercizio Facile

Creare un adattatore per collegare una presa europea a un dispositivo con presa
americana.

Creare un'interfaccia chiamata EuropeanSocket con un metodo giveElectricity().

Realizzare una classe chiamata AmericanSocket con un metodo provideElectricity().

Implementare un Adapter chiamato SocketAdapter che utilizzi AmericanSocket ma
implementi EuropeanSocket.

Testare l'adattatore collegandolo ad un dispositivo europeo.
 */
// Interfaccia target: standard europeo
interface EuropeanSocket {
    // Metodo che fornisce corrente secondo lo standard europeo
    void giveElectricity();
}

// Classe Adaptee: presa americana
class AmericanSocket {
    // Metodo specifico delle prese americane per fornire corrente
    public void provideElectricity() {
        System.out.println("Elettricità fornita da presa americana");
    }
}

// Adapter: converte la presa americana in europea
class SocketAdapter implements EuropeanSocket {
    private AmericanSocket americanSocket; // Riferimento alla presa americana

    // Costruttore: riceve la presa americana da adattare
    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    // Implementa l'interfaccia europea, ma delega alla presa americana
    public void giveElectricity() {
        System.out.println("Adattatore converte la presa europea a americana...");
        americanSocket.provideElectricity();
    }
}

// Classe reale: rappresenta una lampada europea che usa una presa europea
//classe reale che ti permette di testare e vedere il funzionamento pratico dell’Adapter
class EuropeanLamp {
    private EuropeanSocket socket; // Presa europea (adapter)

    // Costruttore: riceve la presa (o adapter) su cui collegarsi
    public EuropeanLamp(EuropeanSocket socket) {
        this.socket = socket;
    }

    // Metodo per accendere la lampada, richiede corrente tramite lo standard europeo
    public void turnOn() {
        System.out.println("Accendo la lampada europea...");
        socket.giveElectricity(); // Usa l'interfaccia europea, adapter farà il resto
        System.out.println("Lampada accesa!\n");
    }
}

// Classe main: test pratico
public class EsercizioAdapterFacile {
    public static void main(String[] args) {
        // Creo una presa americana
        AmericanSocket americanSocket = new AmericanSocket();

        // Creo un adapter per adattare la presa americana a standard europeo
        EuropeanSocket adapter = new SocketAdapter(americanSocket);

        // Creo una lampada europea e la collego tramite l'adapter
        EuropeanLamp lamp = new EuropeanLamp(adapter);

        // Accendo la lampada: tutto funziona, grazie all'adapter
        lamp.turnOn();
    }
}

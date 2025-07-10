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
// Interfaccia "target" (presa europea)
interface EuropeanSocket {
    void giveElectricity(); // Metodo che fornisce elettricità secondo lo standard europeo
}

// Classe "adaptee" (presa americana, già esistente o esterna)
class AmericanSocket {
    public void provideElectricity() {
        System.out.println("Elettricità fornita da presa americana");
    }
}

// Adapter: implementa EuropeanSocket e "adatta" una AmericanSocket
class SocketAdapter implements EuropeanSocket {
    private AmericanSocket americanSocket; // Mantiene un riferimento alla presa americana

    // Costruttore: riceve la presa americana da adattare
    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    // Implementa il metodo richiesto da EuropeanSocket,
    // ma lo fa delegando a provideElectricity() della presa americana
    public void giveElectricity() {
        System.out.println("Adattatore converte la presa europea a americana...");
        americanSocket.provideElectricity();
    }
}

// Classe che rappresenta un dispositivo europeo che vuole ricevere corrente
class EuropeanDevice {
    private EuropeanSocket socket;

    // Costruttore: riceve una presa europea (o un adapter compatibile)
    public EuropeanDevice(EuropeanSocket socket) {
        this.socket = socket;
    }

    // Simula l'uso del dispositivo: richiede corrente tramite la presa europea
    public void powerOn() {
        System.out.println("Dispositivo europeo in accensione...");
        socket.giveElectricity();
        System.out.println("Dispositivo europeo acceso!\n");
    }
}

// MAIN per testare l'adapter
public class EsercizioAdapter {
    public static void main(String[] args) {
        // Crea la presa americana (adaptee, fornita da un fornitore diverso)
        AmericanSocket americanSocket = new AmericanSocket();

        // Crea l'adapter che permette di collegare la presa americana a una spina europea
        EuropeanSocket adapter = new SocketAdapter(americanSocket);

        // Crea un dispositivo europeo, ma lo collega tramite l'adapter
        EuropeanDevice device = new EuropeanDevice(adapter);

        // Accende il dispositivo: l'adapter si occupa della "conversione"
        device.powerOn();
    }
}

/*
Design pattern ES Facile Factory Method

Requisiti:
Interfaccia IVeicolo
    Metodo void Avvia()
    Metodo void MostraTipo()

Classi concrete che implementano IVeicolo:
    Auto → stampa "Avvio dell'auto" e "Tipo: Auto"
    Moto → stampa "Avvio della moto" e "Tipo: Moto"
    Camion → stampa "Avvio del camion" e "Tipo: Camion"

Crea una classe VeicoloFactory con:
    Metodo statico IVeicolo CreaVeicolo(string tipo) che:
        restituisce un oggetto Auto se tipo == "auto"
        restituisce un oggetto Moto se tipo == "moto"
        restituisce un oggetto Camion se tipo == "camion"
        altrimenti restituisce null o stampa un messaggio di errore

Nel Main:
    Chiedi all’utente quale veicolo creare
    Usa VeicoloFactory.CreaVeicolo(...)
    Se il veicolo è valido, chiamane i metodi Avvia() e MostraTipo()
 */

import java.util.Scanner; // Importa la classe Scanner per leggere input da tastiera


interface IVeicolo{
    // Metodo che simula l'avvio del veicolo
    void Avvia();
    // Metodo che mostra il tipo di veicolo
    void MostraTipo();
}


// Ogni classe concreta implementa IVeicolo e definisce il proprio comportamento
class Auto implements IVeicolo{
    @Override
    public void Avvia(){
        System.out.println("Avvio auto ");
    }

    @Override
    public void MostraTipo(){
        System.out.println("Tipo: Ferrari ");
    }
}

class Moto implements IVeicolo{
    @Override
    public void Avvia(){
        System.out.println("Avvio moto");
    }

    @Override
    public void MostraTipo(){
        System.out.println("Tipo: Yamaha ");
    }
}

class Camion implements IVeicolo{
    @Override
    public void Avvia(){
        System.out.println("Avvio camion ");
    }

    @Override
    public void MostraTipo(){
        System.out.println("Tipo: Camion Mercedes ");
    }
}

// Classe astratta Creator (Factory)
// Definisce il factoryMethod (che sarà implementato dalle sottoclassi)
abstract class VeicoloFactory{
    // Metodo factoryMethod: restituisce un oggetto IVeicolo
    public abstract IVeicolo factoryMethod();

    // Metodo di utilità: crea e usa il prodotto (non necessario ma spesso usato come esempio)
    public void anOperation() {
        IVeicolo veicolo = factoryMethod();  // crea il prodotto tramite factory method
        veicolo.Avvia();                     // usa il prodotto
        veicolo.MostraTipo(); 
    }
}

// Creatori concreti: ognuno sa costruire un prodotto diverso
class ConcreteCreator1 extends VeicoloFactory {
    @Override
    public IVeicolo factoryMethod() {
        return new Auto(); // Ritorna un oggetto Auto
    }
}

class ConcreteCreator2 extends VeicoloFactory {
    @Override
    public IVeicolo factoryMethod() {
        return new Moto(); // Ritorna un oggetto Moto
    }
}

class ConcreteCreator3 extends VeicoloFactory {
    @Override
    public IVeicolo factoryMethod() {
        return new Camion(); // Ritorna un oggetto Camion
    }
}

public class EsercizioFactoryMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Per leggere input da tastiera
        VeicoloFactory factory = null; // Factory di riferimento, da impostare in base alla scelta utente

        System.out.print("Quale veicolo vuoi creare? (auto/moto/camion): ");
        String tipo = scanner.nextLine().toLowerCase(); // Legge la scelta dell'utente e la converte in minuscolo

        // In base all'input utente, assegna la factory concreta corretta
        switch (tipo) {
            case "auto":
                factory = new ConcreteCreator1(); // Factory per Auto
                break;
            case "moto":
                factory = new ConcreteCreator2(); // Factory per Moto
                break;
            case "camion":
                factory = new ConcreteCreator3(); // Factory per Camion
                break;
            default:
                System.out.println("Tipo di veicolo non riconosciuto!"); // Input non valido
        }

        // Se la factory è valida (cioè l'utente ha inserito un veicolo corretto)
        if (factory != null) {
            IVeicolo veicolo = factory.factoryMethod(); // Crea il prodotto tramite factory method
            veicolo.Avvia();                            // Avvia il veicolo
            veicolo.MostraTipo();                       // Mostra il tipo
        } else {
            System.out.println("Creazione veicolo fallita."); // Nessuna factory valida, quindi nessun veicolo creato
        }

        scanner.close(); // Chiude lo scanner per evitare warning
    }
}

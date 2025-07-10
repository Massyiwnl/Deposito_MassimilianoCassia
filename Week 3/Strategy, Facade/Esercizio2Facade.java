/*
Esercizio Medio:

Obiettivo: Simulare un sistema di avvio computer usando Facade.

Richiesta:

Crea classi Bios, HardDisk, SistemaOperativo con metodi: inizializza(),
carica(), avvia().

Crea una classe ComputerFacade con metodo accendiComputer() che richiama i
metodi appropriati in sequenza.

In Main, istanzia il Facade e usa accendiComputer() per simulare l'avvio del
PC.
 */

// Sottosistemi (le classi che compongono il sistema complesso)
class Bios {
    public void inizializza() {
        System.out.println("[BIOS] Inizializzazione in corso...");
    }

    public void carica() {
        System.out.println("[BIOS] Caricamento in corso...");
    }

    public void avvia() {
        System.out.println("[BIOS] Avvio in corso...");
    }
}

class HardDisk {
    public void inizializza() {
        System.out.println("[HardDisk] Inizializzazione in corso...");
    }

    public void carica() {
        System.out.println("[HardDisk] Caricamento in corso...");
    }

    public void avvia() {
        System.out.println("[HardDisk] Avvio in corso...");
    }
}

class SistemaOperativo {
    public void inizializza() {
        System.out.println("[SO] Inizializzazione in corso...");
    }

    public void carica() {
        System.out.println("[SO] Caricamento in corso...");
    }

    public void avvia() {
        System.out.println("[SO] Avvio in corso...");
    }
}

// Facade
class ComputerFacade {
    private Bios bios;
    private HardDisk hd;
    private SistemaOperativo so;

    public ComputerFacade() {
        bios = new Bios();
        hd = new HardDisk();
        so = new SistemaOperativo();
    }

    public void accendiComputer() {
        System.out.println("Avvio del computer:");
        bios.inizializza();
        bios.carica();
        bios.avvia();

        hd.inizializza();
        hd.carica();
        hd.avvia();

        so.inizializza();
        so.carica();
        so.avvia();
        System.out.println("Computer avviato!");
    }
}

// Main per testare il Facade
public class Esercizio2Facade {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.accendiComputer();
    }
}

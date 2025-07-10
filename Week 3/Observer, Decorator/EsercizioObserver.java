import java.util.ArrayList;
import java.util.List;

// INTERFACCIA OBSERVER
interface Display {
    void aggiorna(float temperatura); // Metodo che ogni observer DEVE implementare: riceve aggiornamento dal subject.
}

// SUBJECT Stazione Meteo
class StazioneMeteo {
    private List<Display> displays = new ArrayList<>(); // Lista di observer registrati (i display)
    private float temperatura; // Stato osservato: la temperatura

    // Metodo per aggiungere un observer
    public void aggiungiDisplay(Display d) {
        displays.add(d); // Pratica: aggiunge il display alla lista. Teoria: permette la "subscription" degli observer.
    }

    // Metodo per rimuovere un observer
    public void rimuoviDisplay(Display d) {
        displays.remove(d); // Pratica: rimuove il display dalla lista. Teoria: permette l'"unsubscribe".
    }

    // Metodo per notificare tutti gli observer (obbligatorio nel pattern Observer)
    private void notificaDisplay() {
        for (Display d : displays) { // Pratica: scorre la lista degli observer
            d.aggiorna(temperatura); // chiama il loro metodo di aggiornamento, passando la temperatura.
        }
    }

    // Modifica della temperatura: aggiorna lo stato e notifica tutti i display
    public void setTemperatura(float t) {
        this.temperatura = t; // Pratica: aggiorna la temperatura.
        notificaDisplay(); // Teoria: ogni cambiamento dello stato viene comunicato agli observer.
    }
}

// IMPLEMENTAZIONE DI UN OBSERVER Display su Console
class DisplayConsole implements Display {
    public void aggiorna(float temperatura) {
        // in pratica stampa la temperatura aggiornata sul terminale.
        // rappresenta la reazione dell'observer all'update del subject.
        System.out.println("Display Console - Temperatura aggiornata: " + temperatura + "°C");
    }
}

// IMPLEMENTAZIONE DI UN ALTRO OBSERVER Display su Mobile
class DisplayMobile implements Display {
    public void aggiorna(float temperatura) {
        // Simile a sopra, ma può essere una visualizzazione diversa.
        System.out.println("Display Mobile - Temperatura attuale: " + temperatura + "°C");
    }
}

// Main class
public class EsercizioObserver {
    public static void main(String[] args) {
        StazioneMeteo meteo = new StazioneMeteo(); // Crea la stazione meteo (subject)

        Display console = new DisplayConsole(); // Crea il primo display (observer)
        Display mobile = new DisplayMobile();   // Crea il secondo display (observer)

        meteo.aggiungiDisplay(console); // Registra observer 1
        meteo.aggiungiDisplay(mobile);  // Registra observer 2

        meteo.setTemperatura(24.5f); // Cambia la temperatura => notifica entrambi gli observer
        meteo.setTemperatura(28.1f); // Cambia ancora => entrambi vengono notificati di nuovo

        meteo.rimuoviDisplay(console); // Rimuove l'observer console

        meteo.setTemperatura(22.0f); // Ora solo il display mobile riceverà l'update
    }
}
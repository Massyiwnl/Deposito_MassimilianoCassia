package com.example.demo.controller;

import com.example.demo.model.Numeri;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/numeri") //endpoint
public class NumeriControllo {

    private List<Numeri> numeri = new ArrayList<>();
    private Long idCounter = 1L;

    // GET: Lista di numeri
    @GetMapping
    public List<Numeri> getAll() {
        return numeri;
    }

    /* 
    // GET: Somma totale dei numeri
    @GetMapping("/somma")
    public double getSomma() {
        return numeri.stream()
                .mapToDouble(Numeri::getValore)
                .sum();
    }
    */
    @GetMapping("/somma")
    public double getSomma() {
        double somma = 0;
        for (Numeri n : numeri) {
            somma += n.getValore();
        }
        return somma;
    }

    // POST: Aggiungi un nuovo numero
    @PostMapping
    public Numeri aggiungi(@RequestBody Numeri nuovo) {
        nuovo.setId(idCounter++);
        numeri.add(nuovo);
        return nuovo;
    }
    /* 
    // DELETE: Rimuovi per id
    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        boolean removed = numeri.removeIf(n -> n.getId().equals(id));
        return removed ? "Numero eliminato con successo." : "Numero non trovato.";
    }
    */
    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        for (int i = 0; i < numeri.size(); i++) {
            if (numeri.get(i).getId().equals(id)) { //prende il numero alla posizione i (numeri.get(i)), prende l’ID (getId()) e verifica uguaglianza
                numeri.remove(i); // rimuove il numero trovato
                return "Numero eliminato con successo.";
            }
        }
        return "Numero non trovato.";
    }

    //aggiornamento
    @PutMapping("/{id}")
    public String aggiorna(@PathVariable Long id, @RequestBody Numeri modificato) {
        for (Numeri n : numeri) {
            if (n.getId().equals(id)) {
                n.setValore(modificato.getValore());
                return "Numero aggiornato con successo.";
            }
        }
        return "Numero non trovato.";
    }
}

package com.example.demo.controller;

import com.example.demo.model.Numeri;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/numeri")
public class NumeriControllo {

    private final List<Numeri> numeri = new ArrayList<>();
    private Long idCounter = 1L;

    // GET: Lista di numeri
    @GetMapping
    public ResponseEntity<List<Numeri>> getAll() {
        return ResponseEntity.ok(numeri);
    }

    // GET: Somma totale dei numeri
    @GetMapping("/somma")
    public ResponseEntity<Double> getSomma() {
        double somma = 0;
        for (Numeri n : numeri) {
            somma += n.getValore();
        }
        return ResponseEntity.ok(somma);
    }

    // POST: Aggiungi un nuovo numero
    @PostMapping
    public ResponseEntity<Numeri> aggiungi(@RequestBody Numeri nuovo) {
        nuovo.setId(idCounter++);
        numeri.add(nuovo);
        return ResponseEntity.status(201).body(nuovo); // 201 Created
    }

    // DELETE: Rimuovi per id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimina(@PathVariable Long id) {
        for (int i = 0; i < numeri.size(); i++) {
            if (numeri.get(i).getId().equals(id)) {
                numeri.remove(i);
                return ResponseEntity.ok("Numero eliminato con successo.");
            }
        }
        return ResponseEntity.status(404).body("Numero non trovato.");
    }

    // PUT: Aggiorna valore di un numero per id
    @PutMapping("/{id}")
    public ResponseEntity<String> aggiorna(@PathVariable Long id, @RequestBody Numeri modificato) {
        for (Numeri n : numeri) {
            if (n.getId().equals(id)) {
                n.setValore(modificato.getValore());
                return ResponseEntity.ok("Numero aggiornato con successo.");
            }
        }
        return ResponseEntity.status(404).body("Numero non trovato.");
    }
}

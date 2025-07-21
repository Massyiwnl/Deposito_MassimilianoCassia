package com.example.demo.controller;

import com.example.demo.model.Prodotto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    private List<Prodotto> prodotti = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public List<Prodotto> getAll() {
        return prodotti;
    }

    @PostMapping
    public Prodotto crea(@RequestBody Prodotto nuovo) {
        nuovo.setId(idCounter++);
        prodotti.add(nuovo);
        return nuovo;
    }

    @GetMapping("/{id}")
    public Prodotto getById(@PathVariable Long id) {
        return prodotti.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Prodotto aggiorna(@PathVariable Long id, @RequestBody Prodotto modificato) {
        for (Prodotto p : prodotti) {
            if (p.getId().equals(id)) {
                p.setNome(modificato.getNome());
                p.setPrezzo(modificato.getPrezzo());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        prodotti.removeIf(p -> p.getId().equals(id));
        return "Prodotto eliminato con successo.";
    }
}

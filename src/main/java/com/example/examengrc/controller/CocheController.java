package com.example.examengrc.controller;

import com.example.examengrc.model.Coche;
import com.example.examengrc.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coches")
public class CocheController {

    private final CocheService cocheService;

    @Autowired
    public CocheController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @PostMapping
    public ResponseEntity<Coche> addCoche(@RequestBody Coche coche) {
        Coche newCoche = cocheService.saveCoche(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCoche);
    }

    @GetMapping
    public ResponseEntity<List<Coche>> getAllCoches() {
        List<Coche> coches = cocheService.getAllCoches();
        return ResponseEntity.ok(coches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> getCocheById(@PathVariable Long id) {
        Coche coche = cocheService.getCocheById(id);
        return ResponseEntity.ok(coche);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCoche(@PathVariable Long id) {
        cocheService.deleteCoche(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coche> updateCoche(@PathVariable Long id, @RequestBody Coche coche) {
        Coche updatedCoche = cocheService.updateCoche(id, coche);
        if (updatedCoche == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCoche);
    }
}

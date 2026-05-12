package com.example.backend_skins.controller;

import com.example.backend_skins.model.Skin;
import com.example.backend_skins.repository.SkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skins")
@CrossOrigin(origins = "*") // Permite peticiones desde tu frontend
public class SkinController {

    @Autowired
    private SkinRepository skinRepository;

    // Obtener todas las skins
    @GetMapping
    public List<Skin> getAllSkins() {
        return skinRepository.findAll();
    }

    // Guardar una nueva skin
    @PostMapping
    public Skin createSkin(@RequestBody Skin skin) {
        return skinRepository.save(skin);
    }

    // Obtener skin por ID
    @GetMapping("/{id}")
    public ResponseEntity<Skin> getSkinById(@PathVariable Long id) {
        return skinRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar skins por arma (ej: /api/skins/search?weapon=AK-47)
    @GetMapping("/search")
    public List<Skin> getSkinsByWeapon(@RequestParam String weapon) {
        return skinRepository.findByWeapon(weapon);
    }

    // Eliminar una skin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkin(@PathVariable Long id) {
        return skinRepository.findById(id)
                .map(skin -> {
                    skinRepository.delete(skin);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
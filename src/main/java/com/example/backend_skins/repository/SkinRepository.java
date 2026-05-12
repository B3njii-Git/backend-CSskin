package com.example.backend_skins.repository;

import com.example.backend_skins.model.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkinRepository extends JpaRepository<Skin, Long> {
    // Método personalizado para buscar por arma
    List<Skin> findByWeapon(String weapon);
}
package com.example.backend_skins.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // Ej: "AK-47 | Redline"
    private String weapon;      // Ej: "AK-47"
    private String rarity;      // Ej: "Covert"
    private String wear;        // Ej: "Field-Tested"
    private Double floatValue;  // Ej: 0.158
    private Double price;       // Precio estimado
    private String imageUrl;    // Link a la imagen de la skin
}
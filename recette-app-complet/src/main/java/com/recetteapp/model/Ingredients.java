package com.recetteapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String unite;
    private Double prixUnitaire;
}

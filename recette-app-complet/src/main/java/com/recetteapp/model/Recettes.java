package com.recetteapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recette {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private int tempsPreparation;
    private int tempsCuisson;
    private String description;
    private boolean publique;

    @ManyToOne
    private User user;
}

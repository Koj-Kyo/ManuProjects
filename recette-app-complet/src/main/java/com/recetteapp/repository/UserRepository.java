// User Repository

package com.recetteapp.repository;

import com.recetteapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {}

public interface RecetteRepository extends JpaRepository<Recette, Long> {
    List<Recette> findByPubliqueTrue();
    List<Recette> findByUserId(Long userId);
}

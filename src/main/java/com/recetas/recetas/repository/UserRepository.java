package com.recetas.recetas.repository;

import com.recetas.recetas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    
    // Agrega este método para verificar si un nombre de usuario ya existe
    boolean existsByUsername(String username);
}

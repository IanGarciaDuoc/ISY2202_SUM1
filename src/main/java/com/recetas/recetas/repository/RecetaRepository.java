package com.recetas.recetas.repository;

import com.recetas.recetas.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
    List<Receta> findByNombreContainingIgnoreCase(String nombre);
    List<Receta> findAllByOrderByIdDesc();
}
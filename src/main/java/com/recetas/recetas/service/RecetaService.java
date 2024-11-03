
package com.recetas.recetas.service;

import com.recetas.recetas.model.RecetaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecetaService {
    private List<RecetaDTO> recetas = new ArrayList<>();

    public RecetaService() {
        recetas.add(new RecetaDTO(1L, "Pasta Carbonara", "Italiana", "Pasta, huevos, queso pecorino, panceta", "Italia", "Media", 30, "La auténtica pasta carbonara italiana", "1. Cocinar la pasta\n2. Preparar la salsa\n3. Mezclar todo", "/image/1.jpg"));
        recetas.add(new RecetaDTO(2L, "Pollo al Curry", "India", "Pollo, curry, leche de coco, cebolla, ajo", "India", "Fácil", 45, "Delicioso pollo al curry con salsa cremosa de coco", "cocina y listo", "/image/2.jpg"));
        recetas.add(new RecetaDTO(3L, "Tacos al Pastor", "Mexicana", "Carne de cerdo, piña, tortillas, cilantro", "México", "Media", 60, "Tradicionales tacos al pastor con piña y cilantro", "ponele weno", "/image/3.jpg"));
    }

    public List<RecetaDTO> getRecetas() {
        return recetas;
    }
     public List<RecetaDTO> searchRecetas(String nombre, String tipoCocina, String ingredientes, String pais, String dificultad) {
        return recetas.stream().filter(receta -> 
            (nombre == null || receta.getNombre().toLowerCase().contains(nombre.toLowerCase())) &&
            (tipoCocina == null || receta.getTipoCocina().equalsIgnoreCase(tipoCocina)) &&
            (ingredientes == null || receta.getIngredientes().toLowerCase().contains(ingredientes.toLowerCase())) &&
            (pais == null || receta.getPais().equalsIgnoreCase(pais)) &&
            (dificultad == null || receta.getDificultad().equalsIgnoreCase(dificultad))
        ).collect(Collectors.toList());
    }
}

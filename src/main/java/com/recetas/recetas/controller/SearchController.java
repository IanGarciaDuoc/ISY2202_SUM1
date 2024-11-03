package com.recetas.recetas.controller;

import com.recetas.recetas.model.Receta;
import com.recetas.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class SearchController {

    private final RecetaRepository recetaRepository;

    @Autowired
    public SearchController(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    @GetMapping("/buscarRecetas")
    public String buscarRecetas(
            @RequestParam(required = false) String nombre,
            Model model
    ) {
        List<Receta> recetasFiltradas;
        
        if (nombre != null && !nombre.trim().isEmpty()) {
            recetasFiltradas = recetaRepository.findByNombreContainingIgnoreCase(nombre);
        } else {
            recetasFiltradas = recetaRepository.findAllByOrderByIdDesc();
        }
        
        model.addAttribute("recetasRecientes", recetasFiltradas);
        return "fragments/recetas :: recetasList";
    }
}
package com.recetas.recetas.controller;

import com.recetas.recetas.model.Receta;
import com.recetas.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecetasController {

    private final RecetaRepository recetaRepository;

    @Autowired
    public RecetasController(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    @GetMapping("/recetas/{id}")
    public String verReceta(@PathVariable Long id, Model model) {
        Receta receta = recetaRepository.findById(id).orElse(null);

        if (receta != null) {
            model.addAttribute("receta", receta);
            return "receta-detalle";
        } else {
            return "error"; // Cambia esto a una página de error si deseas
        }
    }

    @GetMapping("/mis-recetas")
    public String misRecetas(Model model) {
        model.addAttribute("recetas", recetaRepository.findAll());
        return "mis-recetas";
    }
}

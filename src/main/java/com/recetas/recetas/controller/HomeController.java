package com.recetas.recetas.controller;

import com.recetas.recetas.model.Receta;
import com.recetas.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final RecetaRepository recetaRepository;

    @Autowired
    public HomeController(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        // Obtener todas las recetas desde la base de datos
        List<Receta> recetasRecientes = recetaRepository.findAll();
        
        model.addAttribute("recetasRecientes", recetasRecientes);
        return "home";
    }
}

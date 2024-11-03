package com.recetas.recetas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/registro")
    public String showRegistrationForm() {
        return "registro"; // Esto busca un archivo registro.html en la carpeta de plantillas
    }
}

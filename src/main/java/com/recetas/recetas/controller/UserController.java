package com.recetas.recetas.controller;

import com.recetas.recetas.exception.UsernameAlreadyExistsException;
import com.recetas.recetas.model.User;
import com.recetas.recetas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller // Cambiado de @RestController a @Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody // Indica que este método devuelve JSON
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody // Indica que este método devuelve JSON
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseBody // Indica que este método devuelve JSON
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody // Indica que este método devuelve JSON
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

   @PostMapping("/register")
    public String registerUser(User user, Model model, RedirectAttributes redirectAttributes) {
        try {
            userService.saveUser(user);
            redirectAttributes.addFlashAttribute("message", "Usuario registrado con éxito");
            return "redirect:/login";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "El nombre de usuario ya existe. Por favor, elige otro.");
            return "registro"; // Devuelve a la vista de registro con el mensaje de error
        } catch (UsernameAlreadyExistsException e) {
            model.addAttribute("error", "El nombre de usuario ya existe. Por favor, elige otro.");
            return "registro"; // Devuelve a la vista de registro con el mensaje de error
        }
    }
}

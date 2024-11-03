package com.recetas.recetas.service;

import com.recetas.recetas.model.User;
import com.recetas.recetas.repository.UserRepository;
import com.recetas.recetas.exception.UsernameAlreadyExistsException; // Asegúrate de tener esta clase de excepción en tu proyecto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        // Verificar si el nombre de usuario ya existe
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("username existente");
        }
        // Encriptar la contraseña antes de guardar el usuario
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

package com.recetas.recetas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipoCocina;
    private String ingredientes;
    private String pais;
    private String dificultad;
    private int tiempoPreparacion;
    private String descripcion;
    private String instrucciones;
    private String imagenUrl;

    // Constructor vacío requerido por JPA
    public Receta() {}

    // Constructor con parámetros
    public Receta(String nombre, String tipoCocina, String ingredientes, 
                 String pais, String dificultad, int tiempoPreparacion, 
                 String descripcion, String instrucciones, String imagenUrl) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.ingredientes = ingredientes;
        this.pais = pais;
        this.dificultad = dificultad;
        this.tiempoPreparacion = tiempoPreparacion;
        this.descripcion = descripcion;
        this.instrucciones = instrucciones;
        this.imagenUrl = imagenUrl;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPais() {
        return pais;
    }

    public String getDificultad() {
        return dificultad;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
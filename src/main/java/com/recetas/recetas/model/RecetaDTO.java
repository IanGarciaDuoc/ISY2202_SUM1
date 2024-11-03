package com.recetas.recetas.model;

public class RecetaDTO {
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

   
    public RecetaDTO(Long id, String nombre, String tipoCocina, String ingredientes,
                     String pais, String dificultad, int tiempoPreparacion, 
                     String descripcion, String instrucciones,String imagenUrl) {
        this.id = id;
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
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipoCocina() { return tipoCocina; }
    public String getIngredientes() { return ingredientes; }
    public String getPais() { return pais; }
    public String getDificultad() { return dificultad; }
    public int getTiempoPreparacion() { return tiempoPreparacion; }
    public String getDescripcion() { return descripcion; }
    public String getInstrucciones() { return instrucciones; }  
    public String getImagenUrl() { return imagenUrl; } 
}

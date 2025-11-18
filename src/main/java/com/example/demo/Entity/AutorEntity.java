package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AutorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @OneToMany(mappedBy = "autor")
    private List<PeliculaEntity> listaPeliculas = new ArrayList<>();





    
    @Override
    public String toString() {
        return "AutorEntity [id=" + id + ", nombre=" + nombre + ", listaPeliculas=" + listaPeliculas + "]";
    }

    public AutorEntity() {
    }

        public AutorEntity(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public AutorEntity(int id, String nombre, ArrayList<PeliculaEntity> listaPeliculas) {
        this.id = id;
        this.nombre = nombre;
        this.listaPeliculas = listaPeliculas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PeliculaEntity> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(List<PeliculaEntity> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }


}

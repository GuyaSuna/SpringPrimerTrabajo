package com.example.demo.Entity;

public class ProductoEntity {
    
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    

    //Gets
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public String getCategoria() {
        return categoria;
    }

    //Sets
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    @Override
        public String toString() {
            return "ProductoEntity [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock
                    + ", categoria=" + categoria + "]";
        }

    public ProductoEntity(){}


    public ProductoEntity(int id, String nombre, double precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

}

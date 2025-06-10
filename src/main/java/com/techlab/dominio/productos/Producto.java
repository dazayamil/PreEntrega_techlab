package com.techlab.dominio.productos;

public class Producto {
    private static int id = 0;
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        id++;
    }

    public String getNombre() {
        return this.nombre;
    }
    public double getPrecio() {
        return this.precio;
    }
    public int getCantidadEnStock() {
        return this.cantidadEnStock;
    }
    public void setNombre(String nombre) {
        if(nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar Vacio");
        }
        this.nombre = nombre;
    }
}

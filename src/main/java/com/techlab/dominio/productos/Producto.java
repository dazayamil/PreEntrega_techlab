package com.techlab.dominio.productos;

public class Producto {
    private static int contadorId= 0;
    private int id;
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock){
        this.id = ++contadorId;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
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

    public void actualizarDatos(Producto otro){
        this.nombre = otro.getNombre();
        this.precio = otro.getPrecio();
        this.cantidadEnStock = otro.cantidadEnStock;
    }

    public int getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        if(nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar Vacio");
        }
        this.nombre = nombre;
    }

    public void setCantidadEnStock(int stock) {
        if(stock <= 0){
            throw new IllegalArgumentException("El valor pasado por parametro no puede ser negativo o 0");
        }
        this.cantidadEnStock = stock;
    }

    @Override
    public String toString() {
        return "\n- Id: " + this.id + "\n- Nombre: " + this.nombre + "\n- Precio: " + this.precio + "\n- Cantidad en stock: " + this.cantidadEnStock;
    }
}

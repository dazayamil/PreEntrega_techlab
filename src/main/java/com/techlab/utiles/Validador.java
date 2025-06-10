package com.techlab.utiles;

public class Validador {

    public static void validarDatosProducto(String nombre, double precio, int cantidadEnStock){
        if(nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre del producto no puede estar vacio");
        }
        if(precio <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a $0 - Precio: " + precio);
        }
        if(cantidadEnStock <= 0){
            throw new IllegalArgumentException("La cantidad en stock no puede ser menor/igual a 0 - Stock: " + cantidadEnStock);
        }
    }

    public static void validarIdProducto(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Id ingresado incorrecto. El ID debe ser mayor a 0");
        }
    }
}

package com.techlab.dominio.pedidos;

import com.techlab.dominio.productos.Producto;

public class ItemPedido {
    private Producto producto;
    private int cantidad;

    public ItemPedido(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double costoItem(){
        return this.cantidad * this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return "\nProducto ID: " + this.producto.getId() + "\n Nombre: " + this.producto.getNombre() + "\n Precio: $" + this.producto.getPrecio() + "\n Cantidad solicitada " + this.cantidad;
    }
}

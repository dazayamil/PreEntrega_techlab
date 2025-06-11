package com.techlab.dominio.pedidos;

import com.techlab.dominio.productos.Producto;

public class ItemPedido {
    private Producto producto;
    private int cantidad;

    public ItemPedido(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double costoItem(){
        return this.cantidad * this.producto.getPrecio();
    }
}

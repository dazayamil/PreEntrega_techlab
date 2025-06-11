package com.techlab.dominio.pedidos;

import com.techlab.dominio.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> items;
    private double costoTotal;
    private Cliente cliente;

    public Pedido(Cliente cliente){
        this.items = new ArrayList<>();
        this.costoTotal = 0;
        this.cliente = cliente;
    }

    public List<ItemPedido> getItems() {
        return this.items;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public double costoTotal(){
        if(this.items.isEmpty()){
            System.err.println("No puede realizar este metodo 'Costo Total', porque no tienes ningun producto por comprar ");
        }
        return this.items.stream()
                .mapToDouble(item -> item.costoItem())
                .sum();
    }

    public void agregarItem(ItemPedido item){
        this.items.add(item);
    }

    @Override
    public String toString() {

        String aux = "\nCantidad de Productos: " + this.items.size() + " - Costo Total $" + this.costoTotal + "\n Productos:";
        for (ItemPedido item : this.items) {
            aux += item.toString();
        }
        return aux;
    }
}

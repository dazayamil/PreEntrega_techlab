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

    public double costoTotal(){
        if(this.items.isEmpty()){
            System.err.println("No puede realizar este metodo 'Costo Total', porque no tienes ningun producto por comprar ");
        }
        return this.items.stream()
                .mapToDouble(item -> item.costoItem())
                .sum();
    }
}

package com.techlab.dominio.cliente;

import java.util.ArrayList;
import java.util.List;
import com.techlab.dominio.pedidos.*;

public class Cliente {
    private String nombre;
    private int dni;
    private List<Pedido> pedidos;

    public Cliente(String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido p){
        this.pedidos.add(p);
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public int getDni() {
        return this.dni;
    }
}

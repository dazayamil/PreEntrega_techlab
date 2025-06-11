package com.techlab.servicios;

import com.techlab.dominio.productos.Producto;

import java.util.List;

public class CrudServicio {
    private List<Producto> productos;

    public CrudServicio(List<Producto> productos){
        this.productos = productos;
    }
}

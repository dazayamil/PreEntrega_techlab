package com.techlab.servicios;

import com.techlab.dominio.catalogo.Catalogo;

public class ServiceAdmin extends ServiceTienda{
    public ServiceAdmin(Catalogo catalogo) {
        super(catalogo);
    }

    public void agregarProducto() {
        catalogo.agregarProducto();
    }

    public void eliminarProducto() {
        catalogo.eliminarProducto();
    }

    public void actualizarProducto() {
        catalogo.actualizarProducto();
    }
}

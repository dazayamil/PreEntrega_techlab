package com.techlab.servicios;

import com.techlab.dominio.catalogo.Catalogo;
import com.techlab.dominio.productos.Producto;

import java.util.List;

public class ServiceTienda {
    protected Catalogo catalogo;

    public ServiceTienda(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void listarProductos() {
        if(catalogo.cantidadDeProductos() == 0){
            System.out.println("Sin productos en la Tienda, pronto vamos a tener nuevas cosas");
        }else {
            catalogo.listarProductos();
        }
    }

    public void buscarProductoPorId(){
        catalogo.buscarProductoPorId();
    }
    public void buscarProductoPorNombre(){
        catalogo.buscarProductoPorNombre();
    }


}

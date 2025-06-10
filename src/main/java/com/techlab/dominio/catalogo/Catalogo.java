package com.techlab.dominio.catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlab.dominio.productos.Producto;
import com.techlab.utiles.*;

public class Catalogo {
    private List<Producto> productos;

    public Catalogo(){
        this.productos = new ArrayList<>();
    }

    private Producto solicitarDatosProducto(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del Producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Precio: $");
        double precio = scanner.nextDouble();
        scanner.nextLine(); //Para cortar el buffer
        System.out.print("Cantidad en Stock: ");
        int cantidadEnStock = scanner.nextInt();
        scanner.nextLine();

        return new Producto(nombreProducto, precio, cantidadEnStock);
    }

    public void agregarProducto(){
        Producto p = solicitarDatosProducto();
        Validador.validarDatosProducto(p.getNombre(), p.getPrecio(), p.getCantidadEnStock());
        p.setNombre(Formater.formatearNombre(p.getNombre()));
        this.productos.add(p);
        System.out.println("Producto creado con Exito!");
    }
}

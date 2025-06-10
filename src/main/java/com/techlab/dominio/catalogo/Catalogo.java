package com.techlab.dominio.catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlab.dominio.productos.Producto;
import com.techlab.utiles.*;

public class Catalogo {
    private List<Producto> productos;
    Scanner scanner = new Scanner(System.in);

    public Catalogo(){
        this.productos = new ArrayList<>();
    }

    private Producto solicitarDatosProducto(String mensajeNombre, String mensajePrecio, String mensajeStock){

        System.out.print(mensajeNombre + ": ");
        String nombreProducto = scanner.nextLine();
        System.out.print(mensajePrecio + "$ ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); //Para cortar el buffer
        System.out.print(mensajeStock + ": ");
        int cantidadEnStock = scanner.nextInt();
        scanner.nextLine();

        Validador.validarDatosProducto(nombreProducto, precio, cantidadEnStock );
        return new Producto(Formater.formatearNombre(nombreProducto), precio, cantidadEnStock);
    }

    public void agregarProducto(){
        Producto p = solicitarDatosProducto("Nombre del producto", "Precio producto", "Cantidad en stock");
        this.productos.add(p);
        System.out.println("Producto creado con Exito!");
    }

    public void eliminarProducto(){

    }

    public void eliminarProducto(int idProducto){

    }

    private Producto buscarProductoPorId(int id){
        for (Producto p: this.productos) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void actualizarProducto(){
        int id;
        boolean continuar = true;
        this.listarProductos();

        System.out.print("¿Qué producto desea actualizar?, indicar id: ");
        while(continuar){
            id = scanner.nextInt(); scanner.nextLine();
            Validador.validarIdProducto(id);
            Producto p = buscarProductoPorId(id);
            if(p == null){
                System.err.println("Error, ID ingresado " + id + " invalido, ingrear un ID valido");
            }else{
                p.actualizarDatos(solicitarDatosProducto("Nuevo nombre", "Nuevo precio", "Nueva cantidad en Stock"));
                continuar = false;
            }
            System.out.print("Id producto: ");
        }
        System.out.println("✅ Producto actualizado con éxito.");
    }

    public void listarProductos(){
        int i = 0;
        for (Producto p: this.productos) {
            System.out.println("* Producto " + (i+1) + ":" + p.toString());
        }
        System.out.println();
    }
}

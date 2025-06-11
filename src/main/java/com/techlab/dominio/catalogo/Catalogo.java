package com.techlab.dominio.catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlab.dominio.productos.Producto;
import com.techlab.utiles.Validador;
import com.techlab.utiles.*;

public class Catalogo {
    private List<Producto> productos;
    Scanner scanner = new Scanner(System.in);

    public Catalogo(){
        this.productos = new ArrayList<>();
    }

    public int cantidadDeProductos(){
        return this.productos.size();
    }

    private Producto solicitarDatosProducto(String mensajeNombre, String mensajePrecio, String mensajeStock){

        System.out.print(mensajeNombre + ": ");
        String nombreProducto = scanner.nextLine();
        System.out.print(mensajePrecio + ": $");
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

    public Producto retornarProductoPorId(int id){
        for (Producto p: this.productos) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public Boolean buscarProductoPorId(){
        System.out.println("Ingresar el ID del producto: ");
        int id = scanner.nextInt(); scanner.nextLine();
        Validador.validarIdProducto(id);
        for (Producto producto: this.productos) {
            if(producto.getId() == id){
                producto.toString();
                return true;
            }else{
                System.out.println("Producto con ID " + id + " no encontrado");
            }
        }
        return false;
    }

    public Boolean buscarProductoPorNombre(){
        System.out.println("Ingresar el nombre del producto: ");
        String nombre = scanner.nextLine();
        Validador.validarNombre(nombre);
        for (Producto producto: this.productos) {
            if(producto.getNombre().equals(nombre)){
                producto.toString();
                return true;
            }else{
                System.out.println("Producto con nombre " + nombre + " no encontrado");
            }
        }
        return false;
    }

    private Producto solicitarProductoPorId(){
        int id;
        boolean continuar = true;
        Producto prod;

        while(continuar){
            id = scanner.nextInt(); scanner.nextLine();
            Validador.validarIdProducto(id);
            prod = retornarProductoPorId(id);
            if(prod != null){
                continuar = false;
                return prod;
            }else{
                System.err.println("Error, ID ingresado " + id + " invalido, ingrear un ID valido");
                System.out.println();
                System.out.print("repetir Id producto: ");
            }
        }
        return null;
    }

    public void eliminarProducto(){
        this.listarProductos();
        System.out.print("Indicar el ID del producto a eliminar: ");

        Producto producto = solicitarProductoPorId();
        System.out.println("¿Está seguro de que desea eliminar el producto '" + producto.getNombre() + "'? (si/no): ");
        String opcion = scanner.nextLine().trim().toLowerCase();
        if(opcion.equals("si")){
            this.productos.remove(producto);
            System.out.println("✅ Producto eliminado con éxito.");
        }else {
            System.out.println("❎ Operación cancelada.");
        }

    }

    public void actualizarProducto(){
        this.listarProductos();
        System.out.print("¿Qué producto desea actualizar?, indicar id: ");
        Producto producto = solicitarProductoPorId();

        producto.actualizarDatos(solicitarDatosProducto("Nuevo nombre", "Nuevo precio", "Nueva cantidad en Stock"));
        System.out.println("✅ Producto actualizado con éxito.");
    }

    public void listarProductos(){
        int i = 1;
        for (Producto p: this.productos) {
            System.out.println("===== Producto " + i + "=====" + p.toString());
            i++;
            System.out.println();
        }
    }
}

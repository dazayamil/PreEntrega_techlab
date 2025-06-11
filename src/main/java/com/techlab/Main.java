package com.techlab;

import com.techlab.dominio.catalogo.Catalogo;
import java.util.Scanner;

import com.techlab.dominio.cliente.Cliente;
import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.servicios.ServiceAdmin;
import com.techlab.servicios.ServiceCliente;
import com.techlab.utiles.Autenticador;
import com.techlab.utiles.Formater;
import com.techlab.utiles.Validador;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo tienda = new Catalogo();

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n📦 Bienvenido a la tienda TechLab:");
                System.out.println("1) Ingresar como SuperUsuario");
                System.out.println("2) Ingresar como Cliente");
                System.out.println("3) Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        if (Autenticador.autenticarSuperUsuario(scanner)) {
                            System.out.println("🔐 Usuario registrado con éxito.");
                            mostrarMenuAdmin(tienda, scanner);
                        } else {
                            System.err.println("❌ Usuario o contraseña incorrectos.");
                        }
                        break;
                    case 2:
                        mostrarMenuCliente(tienda, scanner);
                        break;
                    case 3:
                        System.out.println("👋 ¡Gracias por usar TechLab!");
                        continuar = false;
                        break;
                    default:
                        System.err.println("❌ Opción inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static int menuDeBusqueda(Scanner scanner){
        System.out.println("Tipo de Busqueda");
        System.out.println("1) Buscar producto por ID");
        System.out.println("2) Buscar producto por Nombre");
        int opcion = scanner.nextInt(); scanner.nextLine();
        return opcion;
    }

    private static void mostrarMenuAdmin(Catalogo tienda, Scanner scanner) {
        ServiceAdmin serviceAdmin = new ServiceAdmin(tienda);
        boolean seguir = true;
        while (seguir) {
            try {
                System.out.println("\n⚙️ Menú de Administración:");
                System.out.println("1) Agregar producto");
                System.out.println("2) Eliminar producto");
                System.out.println("3) Actualizar producto");
                System.out.println("4) Mostrar productos");
                System.out.println("5) Buscar Producto");
                System.out.println("6) Volver al menú principal");
                System.out.println("7) Salir del programa");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        serviceAdmin.agregarProducto();
                        break;
                    case 2:
                        serviceAdmin.eliminarProducto();
                        break;
                    case 3:
                        serviceAdmin.actualizarProducto();
                        break;
                    case 4:
                        serviceAdmin.listarProductos();
                        break;
                    case 5:
                        int opcionBusqueda = menuDeBusqueda(scanner);
                        if(opcionBusqueda == 1){
                            serviceAdmin.buscarProductoPorId();
                        }else if(opcionBusqueda == 2) {
                            serviceAdmin.buscarProductoPorNombre();
                        }else {
                            System.out.println("❌ Opción inválida");
                        }
                    case 6:
                        seguir = false;
                        break;
                    case 7:
                        System.out.println("👋 ¡Hasta pronto!");
                        System.exit(0); // Termina la ejecución del programa
                        break;
                    default:
                        System.err.println("❌ Opción inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static Cliente solicitarDatosCliente(Scanner scanner){
        System.out.print("Nombre:");
        String nombre = scanner.nextLine();
        System.out.print("Dni: ");
        int dni = scanner.nextInt(); scanner.nextLine();
        Validador.validarDatosCliente(nombre, dni);
        return new Cliente(Formater.formatearNombre(nombre), dni);
    }

    private static void mostrarMenuCliente(Catalogo tienda, Scanner scanner) {
        ServiceCliente serviceCliente = new ServiceCliente(tienda);
        Cliente cliente = solicitarDatosCliente(scanner);
        boolean seguir = true;
        while (seguir) {
            try {
                System.out.println("\n Hola " + cliente.getNombre() + ", Bienvenido a nuestra Tienda TechLab");
                System.out.println("\n⚙️ Menú de Cliente:");
                System.out.println("1) Mostrar Productos");
                System.out.println("2) Crear Pedido");
                System.out.println("3) Listar Pedidos");
                System.out.println("4) Buscar Producto");
                System.out.println("5) Salir del programa");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        serviceCliente.listarProductos();
                        break;
                    case 2:
                        System.out.println("¿Qué productos deseas comprar?");
                        serviceCliente.crearPedido(cliente);
                        break;
                    case 3:
                        serviceCliente.verPedidos(cliente);
                        break;
                    case 4:
                        int opcionBusqueda = menuDeBusqueda(scanner);
                        if(opcionBusqueda == 1){
                            serviceCliente.buscarProductoPorId();
                        }else if(opcionBusqueda == 2) {
                            serviceCliente.buscarProductoPorNombre();
                        }else {
                            System.out.println("❌ Opción inválida");
                        }
                    case 5:
                        seguir = false;
                        System.out.println("👋 ¡Hasta pronto!");
                        System.exit(0); // Termina la ejecución del programa
                        break;
                    default:
                        System.err.println("❌ Opción inválida.");
                }
            } catch (IllegalArgumentException | StockInsuficienteException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
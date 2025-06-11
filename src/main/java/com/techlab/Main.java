package com.techlab;

import com.techlab.dominio.catalogo.Catalogo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo tienda = new Catalogo();

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n📦 Bienvenido a la tienda TechLab:");
                System.out.println("1) Ingresar como SuperUsuario");
                System.out.println("2) Ingresar como Cliente (solo ver productos)");
                System.out.println("3) Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        if (autenticarSuperUsuario(scanner)) {
                            System.out.println("🔐 Usuario registrado con éxito.");
                            mostrarMenuAdmin(tienda, scanner);
                        } else {
                            System.err.println("❌ Usuario o contraseña incorrectos.");
                        }
                        break;
                    case 2:
                        System.out.println("📃 Lista de productos disponibles:");
                        tienda.listarProductos();
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

    private static boolean autenticarSuperUsuario(Scanner scanner) {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String clave = scanner.nextLine();

        return usuario.equals("admin") && clave.equals("1234");
    }

    private static void mostrarMenuAdmin(Catalogo tienda, Scanner scanner) {
        boolean seguir = true;
        while (seguir) {
            try {
                System.out.println("\n⚙️ Menú de Administración:");
                System.out.println("1) Agregar producto");
                System.out.println("2) Eliminar producto");
                System.out.println("3) Actualizar producto");
                System.out.println("4) Mostrar productos");
                System.out.println("5) Volver al menú principal");
                System.out.println("6) Salir del programa");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        tienda.agregarProducto();
                        break;
                    case 2:
                        tienda.eliminarProducto();
                        break;
                    case 3:
                        tienda.actualizarProducto();
                        break;
                    case 4:
                        tienda.listarProductos();
                        break;
                    case 5:
                        seguir = false;
                        break;
                    case 6:
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
}
package com.techlab.servicios;
import com.techlab.dominio.catalogo.Catalogo;
import com.techlab.dominio.cliente.Cliente;
import com.techlab.dominio.pedidos.*;
import com.techlab.dominio.productos.Producto;
import com.techlab.excepciones.StockInsuficienteException;

import java.util.Scanner;

public class ServiceCliente extends ServiceTienda{
    public ServiceCliente(Catalogo catalogo) {
        super(catalogo);
    }

    public void crearPedido(Cliente cliente) throws StockInsuficienteException {
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido(cliente);
        boolean seguirAgregando = true;

        while (seguirAgregando){
            catalogo.listarProductos();
            System.out.print("Ingrese el ID del producto: ");
            int id = scanner.nextInt(); scanner.nextLine();
            Producto producto = catalogo.retornarProductoPorId(id);

            if(producto == null){
                System.out.println("❌ Producto no encontrado. Intente nuevamente.");
                continue;
            }else{
                System.out.print("Ingrese la cantidad deseada: ");
                int cantidad = scanner.nextInt(); scanner.nextLine();
                if (cantidad > producto.getCantidadEnStock()) {
                    throw new StockInsuficienteException("Stock insuficiente");
                } else {
                    ItemPedido item = new ItemPedido(producto, cantidad);
                    pedido.agregarItem(item);
                }
            }

            System.out.print("¿Desea agregar otro producto? (si/no): ");
            String opcion = scanner.nextLine().trim().toLowerCase();
            seguirAgregando = opcion.equals("si");
        }
        // Confirmar pedido
        System.out.print("¿Desea confirmar el pedido? (si/no): ");
        String confirmar = scanner.nextLine().trim().toLowerCase();
        if (confirmar.equals("si")) {
            for (ItemPedido item : pedido.getItems()) {
                Producto p = item.getProducto();
                p.setCantidadEnStock(p.getCantidadEnStock() - item.getCantidad());
            }
            pedido.setCostoTotal(pedido.costoTotal());
            cliente.agregarPedido(pedido);
            System.out.println("✅ Pedido confirmado con exito.");
        } else {
            System.out.println("❌ Pedido cancelado.");
        }
    }

    public void verPedidos(Cliente cliente) {
        for (Pedido pedido : cliente.getPedidos()) {
            System.out.println(pedido.toString());
        }
    }
}

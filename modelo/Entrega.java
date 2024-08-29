/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.entrega;


import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Entrega {
    public static void main(String[] args) {
        // Crear listas para productos, clientes y vendedores
        List<Producto> productos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Vendedor> vendedores = new ArrayList<>();

        // Aquí deberías agregar los objetos previamente creados a las listas

        // Crear una venta
        Venta venta = Venta.crearVenta(productos.toArray(new Producto[0]), clientes.toArray(new Cliente[0]), vendedores.toArray(new Vendedor[0]));

        // Si se requiere factura
        if (venta.requiereFactura()) {
            int numeroFactura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la factura:"));
            Factura factura = new Factura(venta.getCliente(), numeroFactura, venta.getFechaVenta(), productos);
            JOptionPane.showMessageDialog(null, factura.generarFactura());
        }
    }
}
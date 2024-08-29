/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entrega;


import javax.swing.JOptionPane;
import java.util.Date;

public class Venta {
    private Producto producto; // Cambié de static a instancia para permitir que cada venta tenga su propio producto
    private double costoUnitario;
    private double costoTotal;
    private Date fechaVenta;
    private String zona;
    private Cliente cliente;
    private Vendedor vendedor;
    private boolean requiereFactura;

    // Constructor
    public Venta(Producto producto, double costoUnitario, double costoTotal, Date fechaVenta, 
                 String zona, Cliente cliente, Vendedor vendedor, boolean requiereFactura) {
        this.producto = producto;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
        this.fechaVenta = fechaVenta;
        this.zona = zona;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.requiereFactura = requiereFactura;
    }

    // Método para crear una venta 
    public static Venta crearVenta(Producto[] productos, Cliente[] clientes, Vendedor[] vendedores) {
        
        // Seleccionar producto por ID
        int productoId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del producto:"));
        Producto producto = buscarProductoPorId(productos, productoId);

        if (producto == null) {
            throw new NullPointerException("El producto seleccionado no existe.");
        }

        double costoUnitario = producto.getPrecio(); // Ahora obtenemos el precio después de seleccionar el producto
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad vendida:"));
        double costoTotal = costoUnitario * cantidad;
        Date fechaVenta = new Date(); // Fecha actual
        String zona = JOptionPane.showInputDialog("Ingrese la zona de venta:");

        // Seleccionar cliente por ID
        int clienteId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del cliente:"));
        Cliente cliente = buscarClientePorId(clientes, clienteId);

        // Seleccionar vendedor por ID
        int vendedorId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del vendedor:"));
        Vendedor vendedor = buscarVendedorPorId(vendedores, vendedorId);

        // Preguntar si requiere factura
        int respuestaFactura = JOptionPane.showConfirmDialog(null, "¿Requiere factura?", "Factura", JOptionPane.YES_NO_OPTION);
        boolean requiereFactura = (respuestaFactura == JOptionPane.YES_OPTION);

        return new Venta(producto, costoUnitario, costoTotal, fechaVenta, zona, cliente, vendedor, requiereFactura);
    }

    // Buscar Producto
    private static Producto buscarProductoPorId(Producto[] productos, int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto con ID " + id + " no encontrado.");
        return null;
    }

    // Buscar Cliente
    private static Cliente buscarClientePorId(Cliente[] clientes, int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente con ID " + id + " no encontrado.");
        return null;
    }

    // Buscar Vendedor
    private static Vendedor buscarVendedorPorId(Vendedor[] vendedores, int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getIdVendedor() == id) {
                return vendedor;
            }
        }
        JOptionPane.showMessageDialog(null, "Vendedor con ID " + id + " no encontrado.");
        return null;
    }

    public boolean requiereFactura() {
        return requiereFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}

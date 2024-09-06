package com.mycompany.entrega;

import javax.swing.JOptionPane;
import java.util.Date;

public class Venta {
    private Producto producto;
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
        Producto producto = Buscador.buscarProductoPorId(productos, productoId);

        if (producto == null) {
            throw new NullPointerException("El producto seleccionado no existe.");
        }

        double costoUnitario = producto.getPrecio();
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad vendida:"));
        double costoTotal = costoUnitario * cantidad;
        Date fechaVenta = new Date(); // Fecha actual
        String zona = JOptionPane.showInputDialog("Ingrese la zona de venta:");

        // Seleccionar cliente por ID
        int clienteId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del cliente:"));
        Cliente cliente = Buscador.buscarClientePorId(clientes, clienteId);

        if (cliente == null) {
            throw new NullPointerException("El cliente seleccionado no existe.");
        }

        // Seleccionar vendedor por ID
        int vendedorId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del vendedor:"));
        Vendedor vendedor = Buscador.buscarVendedorPorId(vendedores, vendedorId);

        if (vendedor == null) {
            throw new NullPointerException("El vendedor seleccionado no existe.");
        }

        // Preguntar si requiere factura
        int respuestaFactura = JOptionPane.showConfirmDialog(null, "¿Requiere factura?", "Factura", JOptionPane.YES_NO_OPTION);
        boolean requiereFactura = (respuestaFactura == JOptionPane.YES_OPTION);

        return new Venta(producto, costoUnitario, costoTotal, fechaVenta, zona, cliente, vendedor, requiereFactura);
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

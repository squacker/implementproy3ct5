package com.mycompany.entrega;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class Factura {
    private String rfcCliente;
    private String nombreCliente;
    private String domicilioCliente;
    private String telefonoCliente;
    private int numeroFactura;
    private Date fechaEmitida;
    private List<Producto> productos;
    private double impuestoTotal;
    private double costoTotal;

    public Factura(Cliente cliente, int numeroFactura, Date fechaEmitida, List<Producto> productos) {
        this.rfcCliente = cliente.getRfc();
        this.nombreCliente = cliente.getNombre();
        this.domicilioCliente = cliente.getDomicilio();
        this.telefonoCliente = cliente.getTelefono();
        this.numeroFactura = numeroFactura;
        this.fechaEmitida = fechaEmitida;
        this.productos = productos;
        this.impuestoTotal = calcularImpuestoTotal();
        this.costoTotal = calcularCostoTotal();
    }

    // Método para calcular el impuesto total
    private double calcularImpuestoTotal() {
        double totalImpuesto = 0;
        for (Producto producto : productos) {
            totalImpuesto += producto.getPrecio() * 0.16; // 16% de IVA
        }
        return totalImpuesto;
    }

    // Método para calcular el costo total
    private double calcularCostoTotal() {
        double total = 0;
        for (Producto producto : productos) {
            double precioConDescuento = producto.getPrecio() - producto.getDescuento();
            total += precioConDescuento;
        }
        return total + impuestoTotal;
    }

    // Método para generar la información de la factura
    public String generarFactura() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder factura = new StringBuilder();
        factura.append("Factura N°: ").append(numeroFactura).append("\n");
        factura.append("Fecha emitida: ").append(sdf.format(fechaEmitida)).append("\n");
        factura.append("Cliente: ").append(nombreCliente).append("\n");
        factura.append("RFC: ").append(rfcCliente).append("\n");
        factura.append("Domicilio: ").append(domicilioCliente).append("\n");
        factura.append("Teléfono: ").append(telefonoCliente).append("\n");
        factura.append("\nProductos:\n");
        
        for (Producto producto : productos) {
            factura.append("- ").append(producto.getNombre()).append(": $").append(producto.getPrecio())
                    .append(" (Descuento: $").append(producto.getDescuento()).append(")\n");
        }
        
        factura.append("\nImpuesto Total: $").append(impuestoTotal).append("\n");
        factura.append("Costo Total: $").append(costoTotal).append("\n");

        return factura.toString();
    }
}

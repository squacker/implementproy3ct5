package com.mycompany.entrega;

import javax.swing.*;
import java.awt.*;

public class InterfazPrincipal {

    public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("Sistema de Gestión");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Crear el JLabel para el título
        JLabel titleLabel = new JLabel("Sistema de Ventas Alfa 1.0", SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 400, 30); // Coordenadas y tamaño
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        frame.add(titleLabel);

        // Crear los botones
        JButton btnVentas = new JButton("Ventas");
        btnVentas.setBounds(50, 60, 150, 40);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBounds(200, 60, 150, 40);

        JButton btnProductos = new JButton("Productos");
        btnProductos.setBounds(50, 110, 150, 40);

        JButton btnFacturas = new JButton("Facturas");
        btnFacturas.setBounds(200, 110, 150, 40);

        JButton btnVendedores = new JButton("Vendedores");
        btnVendedores.setBounds(125, 160, 150, 40);

        // Añadir los botones al frame
        frame.add(btnVentas);
        frame.add(btnClientes);
        frame.add(btnProductos);
        frame.add(btnFacturas);
        frame.add(btnVendedores);

        // Añadir acción a cada botón
        btnVentas.addActionListener(e -> {
            // Lógica para crear una venta
            Cliente cliente = Cliente.crearCliente();
            Vendedor vendedor = Vendedor.crearVendedor();
            Producto[] productos = {};  // Aquí deberías tener una lista de productos existente
            Venta venta = Venta.crearVenta(productos, new Cliente[]{cliente}, new Vendedor[]{vendedor});
            JOptionPane.showMessageDialog(null, "Venta creada con éxito.");
        });

        btnClientes.addActionListener(e -> {
            Cliente cliente = Cliente.crearCliente();
            JOptionPane.showMessageDialog(null, "Cliente creado: " + cliente.getNombre());
        });

        btnProductos.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Función de productos no implementada.");
        });

        btnFacturas.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Función de facturas no implementada.");
        });

        btnVendedores.addActionListener(e -> {
            Vendedor vendedor = Vendedor.crearVendedor();
            JOptionPane.showMessageDialog(null, "Vendedor creado: " + vendedor.getNombre());
        });

        // Mostrar el frame
        frame.setVisible(true);
    }
}

package com.mycompany.entrega;



import javax.swing.JOptionPane;

public class Buscador {

    // Método para buscar un producto por ID
    public static Producto buscarProductoPorId(Producto[] productos, int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto con ID " + id + " no encontrado.");
        return null;
    }

    // Método para buscar un cliente por ID
    public static Cliente buscarClientePorId(Cliente[] clientes, int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente con ID " + id + " no encontrado.");
        return null;
    }

    // Método para buscar un vendedor por ID
    public static Vendedor buscarVendedorPorId(Vendedor[] vendedores, int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getIdVendedor() == id) {
                return vendedor;
            }
        }
        JOptionPane.showMessageDialog(null, "Vendedor con ID " + id + " no encontrado.");
        return null;
    }
}

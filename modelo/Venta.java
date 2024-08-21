/*
Yadda yadda, we'll get to it later.
*/

package Proyecto;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Venta {
    private static Producto producto;
    private double costoUnitario;
    private double costoTotal;
    private Date fechaVenta;
    private String zona;
    private Cliente cliente;
    private Vendedor vendedor;

    // Constructor
    public Venta(Producto producto, double costoUnitario, double costoTotal, Date fechaVenta, 
                 String zona, Cliente cliente, Vendedor vendedor) {
        this.producto = producto;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
        this.fechaVenta = fechaVenta;
        this.zona = zona;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    // Método para crear una venta 
    public static Venta crearVenta(Producto[] productos, Cliente[] clientes, Vendedor[] vendedores) {


        double costoUnitario = producto.getPrecio();
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad vendida:"));
        double costoTotal = costoUnitario * cantidad;
        Date fechaVenta = new Date(); // Fecha actual
        String zona = JOptionPane.showInputDialog("Ingrese la zona de venta:");

        // Seleccionar producto por ID
        int productoId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del producto:"));
        Producto producto = buscarProductoPorId(productos, productoId);

        // Seleccionar cliente por ID
        int clienteId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del cliente:"));
        Cliente cliente = buscarClientePorId(clientes, clienteId);

        // Seleccionar vendedor por ID
        int vendedorId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del vendedor:"));
        Vendedor vendedor = buscarVendedorPorId(vendedores, vendedorId);

        return new Venta(producto, costoUnitario, costoTotal, fechaVenta, zona, cliente, vendedor);
    }


    //Buscar Producto
    private static Producto buscarProductoPorId(Producto[] productos, int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto con ID " + id + " no encontrado.");
        return null;
    }

    
    //Buscar Cliente
    private static Cliente buscarClientePorId(Cliente[] clientes, int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente con ID " + id + " no encontrado.");
        return null;
    }


    //Buscar Vendedor
    private static Vendedor buscarVendedorPorId(Vendedor[] vendedores, int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getIdVendedor()== id) {
                return vendedor;
            }
        }
        JOptionPane.showMessageDialog(null, "Vendedor con ID " + id + " no encontrado.");
        return null;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Venta{" +
                "producto=" + producto +
                ", costoUnitario=" + costoUnitario +
                ", costoTotal=" + costoTotal +
                ", fechaVenta=" + sdf.format(fechaVenta) +
                ", zona='" + zona + '\'' +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                '}';
    }
}


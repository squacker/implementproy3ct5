package proyecto;

/**
 *
 * @author Diego Ortega
 */
import Proyecto.Vendedor;
import Proyecto.Cliente;
import Proyecto.Producto;
import javax.swing.JOptionPane;

public class Main {
   
    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = Cliente.crearCliente();
        
        
        // Crear un vendedor
        Vendedor vendedor = Vendedor.crearVendedor();
       

        // Crear un Producto 
        /*
        // TO DO: Implementar el método crearProducto. 
        // Usando constructor vacío mientras
        Producto producto = Producto.crearProducto();
        */
        
        Producto producto = new Producto();
        
        // Mostrar información
        JOptionPane.showMessageDialog(null, "Cliente creado: " + cliente);
        JOptionPane.showMessageDialog(null, "Vendedor creado: " + vendedor);
        JOptionPane.showMessageDialog(null, "Producto creado: " + producto);

    }
    
    
}

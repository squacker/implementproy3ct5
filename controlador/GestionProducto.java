package com.mycompany.entrega;

public class GestionProducto {

    // ATRIBUTOS
    private ArrayListProducto productos = new ArrayListProducto("db");
    private IGUProducto interfaz = new IGUProducto();

    // Método principal que controla el menú
    public void ejecutarControlador() {
        String id;
        int opcion;
        
        // CONTROLADOR DE MENU PRINCIPAL
        do {
            opcion = interfaz.menuProducto();

            // SWITCH MENU
            switch (opcion) {
                case 1: // AGREGAR (CREATE)
                    agregarProducto();
                    break;

                case 2: // ELIMINAR (DELETE)
                    eliminarProducto();
                    break;

                case 3: // BUSCAR (READ)
                    buscarProducto();
                    break;

                case 4: // LISTAR (READ)
                    listarProductos();
                    break;

                case 0: // SALIR
                    break;

                default:
                    interfaz.mensaje("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Método para agregar un nuevo producto
    private void agregarProducto() {
        Producto productoNuevo = interfaz.leerDatosProducto();
        productos.agregarProducto(productoNuevo);
        interfaz.mensaje("Producto agregado con éxito.");
    }

    // Método para eliminar un producto por ID
    private void eliminarProducto() {
        String id = interfaz.leerIdProducto();
        if (productos.buscarProductoPorId(id) == -1) {
            interfaz.mensaje("El id que ingresaste no existe");
        } else {
            productos.eliminarProducto(id);
            interfaz.mensaje("Producto eliminado con éxito.");
        }
    }

    // Método para buscar un producto por ID y mostrar sus datos
    private void buscarProducto() {
        String id = interfaz.leerIdProducto();
        int posicion = productos.buscarProductoPorId(id);
        if (posicion == -1) {
            interfaz.mensaje("El id que ingresaste no existe");
        } else {
            Producto productoEscrito = productos.getProducto(posicion);
            interfaz.mensaje(productoEscrito.imprimirDatos());
        }
    }

    // Método para listar todos los productos
    private void listarProductos() {
        interfaz.escribirProductos(productos);
    }
}
public class GestionVenta {

    // ATRIBUTOS
    private ArrayList<Venta> ventas = new ArrayList<>(); // Lista de ventas
    private IGUVentas interfaz = new IGUVentas(); // VISTA

    // METODO PRINCIPAL CLASE VENTA
    public void ejecutarControlador() {
        int opcion;

        // CONTROLADOR DE MENU PRINCIPAL
        do {
            opcion = interfaz.menuVentas();

            // SWITCH MENU
            switch (opcion) {
                case 1: // AGREGAR (CREATE)
                    agregarVenta();
                    break;

                case 2: // ELIMINAR (DELETE)
                    eliminarVenta();
                    break;

                case 3: // BUSCAR (READ)
                    buscarVenta();
                    break;

                case 4: // LISTAR (READ)
                    listarVentas();
                    break;

                case 0: // SALIR
                    break;

                default:
                    interfaz.mensaje("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Métodos que corresponden a cada opción del menú

    // Método para agregar una nueva venta
    private void agregarVenta() {
        Venta nuevaVenta = Venta.crearVenta(obtenerProductos(), obtenerClientes(), obtenerVendedores());
        ventas.add(nuevaVenta);
        interfaz.mensaje("Venta registrada con éxito. Total: " + nuevaVenta.getCostoTotal());
    }

    // Método para eliminar una venta por ID
    private void eliminarVenta() {
        int idEliminar = interfaz.leerIdVenta();
        Venta ventaAEliminar = buscarVentaPorId(idEliminar);

        if (ventaAEliminar != null) {
            ventas.remove(ventaAEliminar);
            interfaz.mensaje("Venta eliminada con éxito.");
        } else {
            interfaz.mensaje("El id que ingresaste no existe.");
        }
    }

    // Método para buscar una venta por ID y mostrar sus datos
    private void buscarVenta() {
        int idBuscar = interfaz.leerIdVenta();
        Venta ventaBuscada = buscarVentaPorId(idBuscar);

        if (ventaBuscada != null) {
            interfaz.mensaje(ventaBuscada.imprimirDatos());
        } else {
            interfaz.mensaje("El id que ingresaste no existe.");
        }
    }

    // Método para listar todas las ventas
    private void listarVentas() {
        interfaz.escribirVentas(ventas);
    }
}
class ControladorCentral {


// ATRIBUTOS

    private static IGUPrincipal interfaz = new IGUPrincipal ();

    private static GestionProducto controladorProducto = new GestionProducto();

   


// FUNCION MAIN 

    public static void main(String[] args) {

        int opcion;

        do {

            opcion = interfaz.menuPrincipal();

            // SWITCH MENU

            switch (opcion) {

                case 1: // GESTIONAR PRODUCTOS

                    controladorProducto.ejecutarControlador();
                    break;

                case 2: // GESTIONAR Cliente

                    controladorClientes.ejecutarControlador();
                    break;

                case 3: // GESTIONAR Vendedor

                    controladorVendedores.ejecutarControlador();
                    break;

                case 4: // GESTIONAR Venta

                    controladorVentas.ejecutarControlador();
                    break;

                case 0: // SALIR

                    break;

            }

        } while(opcion != 0);



    }

     
    
}
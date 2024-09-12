package com.mycompany.entrega;

public class GestionCliente {

   private ArrayListCliente clientes = new ArrayListCliente();

   private IGUCliente interfaz = new IGUCliente();

   public void ejecutarControlador(){

      //variables auxiliares 

      String id;
      int opcion;
      cliente ClienteNuevo;

      //Controlador del menu principal
      do{
         opcion = interfaz.menuCliente;

         switch (opcion) {

            case 1: //Agregar cliente (CREATE)

               agregarCliente();
            
               break;

            case 2: //Eliminar Cliente (DELETE)

                  eliminarCliente();

               break;

            case 3: //Buscar Cliente (READ)

                  BuscarCliente(id);

               break;

            case 4: //Listar Cliente (READ)

                  ListarCliente();

               break;

            case 5:

               break;

            case 0://Salir

               break;
         
            default:

               interfaz.mensaje("opcion no valida");

               break;
         }
      }while(opcion != 0);
   }


   private void agregarCliente() {

      ClienteNuevo = Cliente.leerDatosCliente();

      Cliente.crearCliente(ClienteNuevo);

   }
   

   private void eliminarCliente() {

      id.interfaz.leerIdCliente();

      if (Cliente.buscarClientePorId(id) == -1)

      {

         interfaz.mensaje("El id del cliente no existe");

      } else {

         Cliente.eliminarCliente(id);
      }
   }

   private void buscarCliente() {

      String id = interfaz.leerIdCliente();

      int cliente = clientes.buscarClientePorId(id);

      if (posicion == -1) {

         interfaz.mensaje("El id del cliente que ingresaste no existe");

      } else {

         Cliente clienteEscrito = clientes.getIdCliente(posicion);
         interfaz.mensaje(clienteEscrito.imprimirDatos());
      }
   }

   private void ListarCliente() {
      
      interfaz.escribirCliente(clientes);
            
   }
}
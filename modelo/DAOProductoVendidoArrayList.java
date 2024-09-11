
package com.mycompany.entrega;

import java.util.*;


public class DAOProductoVendidoArrayList implements IDAOProductoVendido{
    
    private List<ProductoVendido> listaProductos = new ArrayList<>();
    
    public DAOProductoVendidoArrayList(){
    
    }
    
    public boolean insertarProductoVendido(ProductoVendido producto){
    
        return listaProductos.add(producto);
        
    }
  
    public boolean borrarProductoVendido(int idProducto){
    
        return listaProductos.remove(idProducto); //Como borrar??
    
    }
    
    
    
}

package modelo;

import java.util.ArrayList;

public class Tienda {

    ArrayList<Producto> productos = new ArrayList();
    ArrayList<Venta> ventas = new ArrayList();

    public Tienda() {        
    }

    public void addProducto(Producto p) {
        try {
            productos.add(p);
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public boolean addVenta(Venta v) {
        try {
            ventas.add(v);
            return true;
        } catch (Exception error) {
            System.out.println(error);
            return false;
        }
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }   

    public ArrayList<Producto> getProductos() {
        return productos;
    }

}

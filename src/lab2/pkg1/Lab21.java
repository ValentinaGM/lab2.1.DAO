package lab2.pkg1;

import modelo.Producto;
import modelo.DAO.ProductoDAO;
import modelo.Tienda;
import vista.VentanaInicio;

public class Lab21 {

    public static void main(String[] args) {
        ProductoDAO p = new ProductoDAO();
        
        p.eliminar(3);
        VentanaInicio inicio = new VentanaInicio();

        inicio.setVisible(true);
    }

}

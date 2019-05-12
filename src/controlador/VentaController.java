package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.DAO.ProductoDAO;
import modelo.Tienda;
import modelo.Venta;
import vista.VentanaVenta;

public class VentaController implements ActionListener {

    private JTable tabla;
    private VentanaVenta formulario;
    
    private int total;

    public VentaController(JTable tabla, VentanaVenta formulario) {
        this.tabla = tabla;
        this.formulario = formulario;        
        this.total = 0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String comando = ae.getActionCommand();

        if (comando.equals("buscar")) {
            ProductoDAO p = new ProductoDAO();            
            String codigo = formulario.getTfBuscar().getText();
            Producto resultado = p.buscar(codigo);
            if (resultado != null) {
                formulario.setTfCategoria(resultado.getCategoria());
                formulario.setTfColor(resultado.getColor());
                formulario.setTfNombre(resultado.getNombre());
                formulario.setTfPrecio(String.valueOf(resultado.getPrecio()));
                formulario.setTfTallaNumero(resultado.getTallaNumero());
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado, ingrese otro código", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (comando.equals("añadir")) {
            DefaultTableModel d = (DefaultTableModel) tabla.getModel();
            int cantidad = (int) formulario.getCantidad().getValue();
            int precio = Integer.parseInt(formulario.getTfPrecio().getText());
            int subtotal = cantidad * precio;
            Object[] venta = {cantidad, formulario.getTfNombre().getText(), precio, subtotal};
            d.addRow(venta);

            total = total + subtotal;
            formulario.setTfTotal(String.valueOf(total));
        }

        /*if (comando.equals("venta")) {
            DefaultTableModel d = (DefaultTableModel) tabla.getModel();
            int nroProd = 0;
            for (int i = 0; i < d.getRowCount(); i++) {
                nroProd = nroProd + (int) d.getValueAt(i, 0);
            }

            ArrayList<Venta> ventas = tienda.getVentas();
            Venta v = new Venta(ventas.size() + 1, nroProd, total);
            if (tienda.addVenta(v)) {
                JOptionPane.showMessageDialog(null, "Venta realizada con éxito", "Emitir Venta", JOptionPane.INFORMATION_MESSAGE);
                this.total = 0;
            }
            formulario.dispose();
        } */
    }

}

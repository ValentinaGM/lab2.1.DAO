
package modelo;


public class Venta {
    private int nroVenta;
    private int nroProductos;
    private int total;

    public Venta(int nroVenta, int nroProductos, int total) {
        this.nroVenta = nroVenta;
        this.nroProductos = nroProductos;
        this.total = total;
    }

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVventa) {
        this.nroVenta = nroVventa;
    }

    public int getNroProductos() {
        return nroProductos;
    }

    public void setNroProductos(int nroProductos) {
        this.nroProductos = nroProductos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
   
}

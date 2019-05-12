
package modelo;


public class Producto {
    private String codigo;
    private String nombre;
    private String categoria;
    private String tallaNumero;
    private String Color;    
    private int precio;

    public Producto(String codigo, String nombre, String categoria, String Color, String tallaNumero, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.Color = Color;
        this.tallaNumero = tallaNumero;
        this.precio = precio;
    }

    public Producto() {
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getTallaNumero() {
        return tallaNumero;
    }

    public void setTallaNumero(String tallaNumero) {
        this.tallaNumero = tallaNumero;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
            
}

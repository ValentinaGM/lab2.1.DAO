/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Producto;

/**
 *
 * @author valen
 */
public class ProductoDAO {
    Conexion con;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public ProductoDAO() {
        this.con = new Conexion();
        connection = con.getConexion();
    }
    
    public boolean insertar(Producto producto) {
        boolean respuesta = false;
        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO producto (nombre, categoria, color, tallaNumero, precio)"
                    + "VALUES ('" + producto.getNombre() + "' , '" + producto.getCategoria() + "' , '" + producto.getColor() + 
                    "' , '" + producto.getTallaNumero() + "' , '" + producto.getPrecio() + "' ); ";
            statement.executeUpdate(sql);
            respuesta = true;
        } catch (SQLException ex) {
            System.out.println(ex);            
        } finally {
            return respuesta; 
        }
    }

   
    public boolean eliminar(int codigo) {
        boolean respuesta = false;

        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM producto"
                    + " WHERE id= '" + codigo + "'";
            statement.executeUpdate(sql);
            respuesta = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            return respuesta;
        }

    }

    
    public boolean actualizar(Producto producto) {
        boolean respuesta = false;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE producto "
                    + "SET nombre='" + producto.getNombre() + "' , categoria ='" + producto.getCategoria() + "' , color='" + producto.getColor()
                    + "' , tallaNumero='" + producto.getTallaNumero() + "' , precio='" + producto.getPrecio()
                    + " WHERE id= '" + producto.getCodigo()+ "'";
            statement.executeUpdate(sql);
            respuesta = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            return respuesta;
        }
    }

    
    public Producto buscar(String codigo) {
        Producto respuesta = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM producto WHERE id = '" + codigo + "'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                respuesta = new Producto();
                respuesta.setCodigo(resultSet.getString("id"));                
                respuesta.setNombre(resultSet.getString("nombre"));
                respuesta.setCategoria(resultSet.getString("categoria"));
                respuesta.setColor(resultSet.getString("color"));
                respuesta.setTallaNumero(resultSet.getString("tallaNumero"));
                respuesta.setPrecio(Integer.parseInt(resultSet.getString("precio")));             

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            return respuesta;
        }
    }
    
    
    public ArrayList<Producto> buscarTodos() {
        ArrayList<Producto> respuesta = new ArrayList();
        try {
            
            statement = connection.createStatement();
            String sql = "SELECT * FROM producto";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setCodigo(resultSet.getString("id"));                
                producto.setNombre(resultSet.getString("nombre"));
                producto.setCategoria(resultSet.getString("categoria"));
                producto.setColor(resultSet.getString("color"));
                producto.setTallaNumero(resultSet.getString("tallaNumero"));
                producto.setPrecio(Integer.parseInt(resultSet.getString("precio")));
                respuesta.add(producto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            return respuesta;
        }
    }
}

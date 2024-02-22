/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import crud_admon.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guillermo Mata
 */
public class INVENTARIO_DAO {

    Conexion conexion = new Conexion(); // es la instancia de conexion we 
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        String sql = "select * from Inventario";
        List<INVENTARIO> lista_inventario = new ArrayList<>();
        try {
            con = conexion.conectarbd();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                INVENTARIO inventario = new INVENTARIO();
                inventario.setId(0);
                inventario.setNombreCorto(rs.getString(1));
                inventario.setDescripcion(rs.getString(2));
                inventario.setSerie(rs.getString(3));
                inventario.setColor(rs.getString(4));
                inventario.setTipo_Adquision(rs.getString(5));
                inventario.setObservaciones(rs.getString(6));
                // los numeros q salen despues de los getters son la posicion de la columna pa hacerlo mas facil
                lista_inventario.add(inventario);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e);
        }
        return lista_inventario;

    }

    //METODO DE AGREGAR (BOTON)
    public void agregar(INVENTARIO inventario) {
        String sql = "insert into Inventario  (NombreCorto, Descripcion, Serie, Color, FechaAdquision, TipoAdquision, Observaciones) VALUES (?, ?, ?, ?, ?, ?, ? )";

        try {
            con = conexion.conectarbd();
            ps = con.prepareStatement(sql);
            ps.setString(1, inventario.getNombreCorto());
            ps.setString(2, inventario.getDescripcion());
            ps.setString(3, inventario.getSerie());
            ps.setString(4, inventario.getColor());
            ps.setString(5, inventario.getFecha_Adquision());
            ps.setString(6, inventario.getTipo_Adquision());
            ps.setString(7, inventario.getObservaciones());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en agregar" + e);
        }
    }
     public void actualizar(INVENTARIO inventario) {
        String sql = "UPDATE Inventario SET NombreCorto=?, Descripcion=?, Serie=?, Color=?, FechaAdquision=?, TipoAdquision=?, Observaciones=? WHERE id=?";

        try {
            con = conexion.conectarbd();
            ps = con.prepareStatement(sql);
            ps.setString(1, inventario.getNombreCorto());
            ps.setString(2, inventario.getDescripcion());
            ps.setString(3, inventario.getSerie());
            ps.setString(4, inventario.getColor());
            ps.setString(5, inventario.getFecha_Adquision());
            ps.setString(6, inventario.getTipo_Adquision());
            ps.setString(7, inventario.getObservaciones());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en agregar" + e);
        }
    }
     //METODO BORRAR (BOTON)
                public void borrar (int id){
                String sql = "delete from Inventario where codigo= " + id;
                try {
                    con = conexion.conectarbd();
                    ps=con.prepareStatement(sql);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error en borrar " + e);
                }
            }
}

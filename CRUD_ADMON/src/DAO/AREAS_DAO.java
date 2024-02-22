/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
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
public class AREAS_DAO {
    Conexion conexion = new Conexion(); // es la instancia de conexion we 
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
     public List listar(){
                String sql = "select * from Areas ";
                List<AREAS> lista =  new ArrayList<>();
                try {
                    con = conexion.conectarbd();
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        AREAS reporte = new AREAS();
                        reporte.setId(rs.getInt(0));
                        reporte.setNombre(rs.getString(1));
                        reporte.setUbicacion(rs.getString(2));
                        
                        
                        
                        // los numeros q salen despues de los getters son la posicion de la columna pa hacerlo mas facil
                        lista.add(reporte);

                    }
                } catch (SQLException e) {
                    System.out.println("Error al listar: " + e);
                }
                return lista;
            }
}

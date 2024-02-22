/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guillermo Mata
 */
public class Conexion {
    Connection con;
    String driver = "com.mysql.cj.jdbc.Driver";
    String dbName = "itsur";
    String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    String Usuario = "root";
    String clave = "hola1234";
        
        public Connection conectarbd(){
            try{
                Class.forName(driver);
                con = DriverManager.getConnection(url, Usuario, clave); 
                System.out.println("Conexion exitosa");
            }catch(ClassNotFoundException | SQLException e) {
                System.out.println("Error de la conexión: " + e.getMessage());
            }
            finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            // Manejar la excepción de cierre si es necesario
            e.printStackTrace();
        }
    }
            return con;
        }
}


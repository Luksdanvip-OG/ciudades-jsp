package testing;

import java.sql.*;



public class MainTesting {
    public static void main(String[] args) {
        System.out.println("Clase para testing v1");
        Connection conn;
        try {
            conn = datos.ConexionMysql.obtenerConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
       
    }
}

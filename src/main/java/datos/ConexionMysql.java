/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import configuracion.PropiedadesConexion;
import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 *
 * @author Luksdanvip
 */
public class ConexionMysql {

    public static DataSource obtenerDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(PropiedadesConexion.JDBC_URL);
        ds.setUsername(PropiedadesConexion.JDBC_USER);
        ds.setPassword(PropiedadesConexion.JDBC_PASSWORD);
        ds.setInitialSize(50);
        return ds;
    }
    
    public static Connection obtenerConexion() throws SQLException{
        return obtenerDataSource().getConnection();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import configuracion.PropiedadesConexion;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;

public class ConexionMysql {

    public static DataSource obtenerDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl(PropiedadesConexion.JDBC_URL);
        ds.setUsername(PropiedadesConexion.JDBC_USER);
        ds.setPassword(PropiedadesConexion.JDBC_PASSWORD);
        ds.setInitialSize(2);
        ds.setMinIdle(2);
        ds.setMaxIdle(4);
        ds.setMaxTotal(4);
        ds.setMaxWaitMillis(10000);
        return ds;
    }

    public static Connection obtenerConexion() throws SQLException {
        return obtenerDataSource().getConnection();
    }

}

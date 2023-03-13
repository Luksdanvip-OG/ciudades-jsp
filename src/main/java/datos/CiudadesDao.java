package datos;

import entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CiudadesDao {

    public static ArrayList<Ciudad> obtenerListadoCiudades() {
        String sql = "SELECT * FROM CITY";
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();
        Ciudad c;
        try {
            PreparedStatement ps;
            ResultSet rs;
            try (Connection conexion = ConexionMysql.obtenerConexion()) {
                ps = conexion.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    c = new Ciudad();
                    c.setId(rs.getLong("ID"));
                    c.setNombre(rs.getString("Name"));
                    c.setCodigoPais(rs.getString("CountryCode"));
                    c.setDistrito(rs.getString("District"));
                    c.setPoblacion(rs.getInt("Population"));
                    listaCiudades.add(c);
                }
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(CiudadesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCiudades;

    }

}

package datos;

import entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CiudadesDao {

    public static ArrayList<Ciudad> obtenerListadoCiudades() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            @SuppressWarnings("UnusedAssignment")
            Ciudad c = null;
            ArrayList<Ciudad> ciudades = new ArrayList<>();

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM city");
            rs = stmt.executeQuery();
            while (rs.next()) {
                c = new Ciudad();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("name"));
                c.setCodigoPais(rs.getString("countrycode"));
                c.setPoblacion(rs.getInt("population"));
                c.setDistrito(rs.getString("district"));
                ciudades.add(c);
            }
            return ciudades;
        } catch (SQLException ex) {
            System.out.println("Error al obtener los datos");
            return null;
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

    }

}

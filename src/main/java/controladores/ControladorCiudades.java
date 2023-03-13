/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import datos.CiudadesDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorCiudades", urlPatterns = {"/ControladorCiudades"})
public class ControladorCiudades extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList ciudades;

        try {
            ciudades = CiudadesDao.obtenerListadoCiudades();
            request.setAttribute("ciudades", ciudades);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCiudades.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("/paginas/home.jsp").forward(request, response);

    }

}

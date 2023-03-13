/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import datos.CiudadesDao;
import entidades.Ciudad;
import java.io.IOException;
import java.util.ArrayList;
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
        //Aqui devolveremos las ciudades
        System.out.println("Entramos en el do get");
        ArrayList<Ciudad> listaCiudades = CiudadesDao.obtenerListadoCiudades();
        
        request.setAttribute("ciudades", listaCiudades);
       
        response.sendRedirect(request.getContextPath() + "/paginas/home.jsp");
    }



}

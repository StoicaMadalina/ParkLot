/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.CarDetails;
import com.park.parkinglot.common.UserDetails;
import com.park.parkinglot.ejb.CarBean;
import com.park.parkinglot.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditCar", urlPatterns = {"/EditCar"})
public class EditCar extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    CarBean carBean;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);

        int carId = Integer.parseInt(request.getParameter("id"));
        CarDetails car = carBean.findById(carId);
        request.setAttribute("car", car);

        request.getRequestDispatcher("/WEB-INF/pages/editCar.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String licensePlate = request.getParameter("license_plate");
        String parkingSpot = request.getParameter("parking_spot");
        int UserId = Integer.parseInt(request.getParameter("owner_id"));
        int carId = Integer.parseInt(request.getParameter("car_id"));
        carBean.updateCar(carId, licensePlate, parkingSpot, UserId);
        response.sendRedirect(request.getContextPath() + "/Cars");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

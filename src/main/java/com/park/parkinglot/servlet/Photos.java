package com.park.parkinglot.servlet;

import com.park.parkinglot.common.PhotoDetails;
import com.park.parkinglot.ejb.CarBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Photos", value = "/Photos")
public class Photos extends HttpServlet {
    @Inject
    CarBean carBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer carId = Integer.parseInt(request.getParameter("id"));
        PhotoDetails photo = carBean.findPhotoByCarId(carId);
        if (photo != null) {
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFileContent().length);
            response.getOutputStream().write(photo.getFileContent());
        }
        else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND); //Error 404
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

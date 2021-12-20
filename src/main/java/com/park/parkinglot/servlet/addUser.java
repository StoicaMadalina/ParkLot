package com.park.parkinglot.servlet;

import com.park.parkinglot.ejb.UserBean;
import com.park.parkinglot.util.PasswordUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addUser", value = "/addUser")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole"}))
public class addUser extends HttpServlet {
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");

        String passwordSha256 = PasswordUtil.convertToSha256(password);

        userBean.createUser(username,email,passwordSha256, position);

        response.sendRedirect(request.getContextPath() + "/Users");
    }
}

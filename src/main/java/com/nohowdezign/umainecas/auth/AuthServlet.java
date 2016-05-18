package com.nohowdezign.umainecas.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Noah Howard
 */
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        CASLoginClient loginClient = new CASLoginClient();
        String loginReturn = loginClient.login(request.getParameter("username"), request.getParameter("password"));
        if(loginClient.isLoginSuccessful(loginReturn)) {
            printWriter.println("{\"status\":\"success\"}");
        } else {
            printWriter.println("{\"status\":\"error\"}");
        }
    }
}

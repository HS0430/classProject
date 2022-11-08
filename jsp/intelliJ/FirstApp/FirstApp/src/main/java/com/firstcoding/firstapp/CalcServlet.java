package com.firstcoding.firstapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", value = "/CalcServlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>"+num1+"+"+num2+"="+ (num1+num2) +"</h3>");
        out.println("<h3>"+num1+"-"+num2+"="+ (num1-num2) +"</h3>");
        out.println("<h3>"+num1+"*"+num2+"="+ (num1*num2) +"</h3>");
        out.println("<h3>"+num1+"/"+num2+"="+ (num1/num2) +"</h3>");
        out.println("</body>");
        out.println("</html>");
    }
}

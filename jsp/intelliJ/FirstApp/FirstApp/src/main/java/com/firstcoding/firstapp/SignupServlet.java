package com.firstcoding.firstapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", value = "/SignupServlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");
        String userName = req.getParameter("userName");
        String memo = req.getParameter("memo");
        String gender = req.getParameter("gender");
        String[] langs = req.getParameterValues("Lang");
        String year = req.getParameter("year");

        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("text/html; charset=utf-8");

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<title>SignUpHtml</title>");
        out.println("</html>");
        out.println("<body>");
        out.println("<h3>ID "+userId+"</h3>");
        out.println("<h3>Pwd "+userPwd+"</h3>");
        out.println("<h3>Name "+userName+"</h3>");
        out.println("<h3>Memo "+memo+"</h3>");
        out.println("<h3>Gender "+gender+"</h3>");
        for(String lang : langs){
            out.println("<h3>Lang "+lang+"</h3>");
        }
        out.println("<h3> Year "+year+"</h3>");
        out.println("<a href='http://localhost:8080/signup.html'>돌아가기</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
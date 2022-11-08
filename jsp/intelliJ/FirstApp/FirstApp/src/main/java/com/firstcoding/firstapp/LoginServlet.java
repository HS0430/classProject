package com.firstcoding.firstapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자가 입력한 데이터를 추출
        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        if(userId.equals(userPwd)) {
            resp.sendRedirect("mypage.jsp");
        }
        else{
            resp.sendRedirect("login.html");
        }

//        PrintWriter out = resp.getWriter();
//
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>MyServlet</title>");
//        out.println("</html>");
//        out.println("<body>");
//        out.println("<h1>MyServlet</h1>");
//        out.println("</body>");
//        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

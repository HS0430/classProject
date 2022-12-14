package com.firstcoding.firstapp.cookie;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieSearchServlet", value = "/cookie/search")
@Log4j2
public class CookieSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieName = request.getParameter("cname");
        String value = "";

        Cookie[] cookies = request.getCookies();
        for(int i=0; i<cookies.length; i++){
            Cookie c = cookies[i];
            if(cookieName.equals(c.getValue())){
                value = c.getValue();
                break;
            }
        }

        request.setAttribute("result", value);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/search.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

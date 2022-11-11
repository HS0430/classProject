package com.firstcoding.todo.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRemoveController", value = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("delete post ...");

        // 삭제하고자 하는 todo의 tno 값을 받는다
        String tno = request.getParameter("tno");
        System.out.println("삭제할 tno 번호 : " +tno);

        response.sendRedirect("/todo/list");
    }
}
package com.todo.todospring.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String exceptionNumber(NumberFormatException exception){
        log.info(exception.getMessage());
        return "NumberFormatException ...";
    }

//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    public String exceptionNull(NullPointerException exception){
//        log.info(exception.getMessage());
//        return "NullPointerException ...";
//    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception exception){
        log.info(exception.getMessage());
        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        StringBuffer buffer = new StringBuffer("<h1>");
        buffer.append(exception.getMessage() + "</h1>");
        buffer.append("<hr>");

        for(StackTraceElement element : stackTraceElements){
            buffer.append("<div>" + element + "</div>");
        }

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "notfound404";
    }

}

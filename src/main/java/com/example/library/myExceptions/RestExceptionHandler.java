package com.example.library.myExceptions;

import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(RepeaterElements.class)
    public ModelAndView handRepeaterElements(RepeaterElements ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

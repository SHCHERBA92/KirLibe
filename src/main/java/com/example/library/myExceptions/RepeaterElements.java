package com.example.library.myExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class RepeaterElements extends RuntimeException{
    public RepeaterElements(String message) {
        super(message);
    }
}

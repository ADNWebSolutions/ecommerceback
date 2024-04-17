package com.ADN.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ElementNotFoundByIdException extends RuntimeException{

    private static final long serialVersionID =1L;
    
    
}

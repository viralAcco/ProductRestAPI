package com.accolite.product.exception;

public class ProductException extends RuntimeException{
    private static final long serviceVersionUID = 1L;

    public ProductException(String message){
        super(message);
    }

    public ProductException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

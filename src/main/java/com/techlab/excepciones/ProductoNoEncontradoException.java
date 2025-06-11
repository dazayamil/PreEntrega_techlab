package com.techlab.excepciones;

public class ProductoNoEncontradoException extends Exception{
    public ProductoNoEncontradoException(String mensaje){
        super(mensaje);
    }

    public ProductoNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.educandoweb.workshop.services.exceptions;

public class DatabaseException extends RuntimeException{

    private static final long serialVersionUID = 3555034724754595727L;

    public DatabaseException(String msg){
        super(msg);
    }
}

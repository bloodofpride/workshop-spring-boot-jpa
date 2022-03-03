package com.educandoweb.workshop.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -5608764264640735334L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id "+id);
    }
}

package br.academico.academico.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message){
        super(message);
    }
}

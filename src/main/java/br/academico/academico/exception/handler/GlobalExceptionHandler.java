package br.academico.academico.exception.handler;


import br.academico.academico.exception.StudentNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEmail(StudentNotFoundException ex, HttpServletRequest request) {
        ErrorResponse error = this.createErrorResponse(HttpStatus.NOT_FOUND.value(), "NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    private ErrorResponse createErrorResponse(int httpStatus,String messageHttpStatus,String messageException,String uri){

        return new ErrorResponse(
                Instant.now(),
                httpStatus,
                messageHttpStatus,
                messageException,
                uri
        );
    }
}

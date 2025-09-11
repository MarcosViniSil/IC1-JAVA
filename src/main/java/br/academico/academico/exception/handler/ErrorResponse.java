package br.academico.academico.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private Instant timeError;
    private int httpStatus;
    private String messageHttpStatus;
    private String messageException;
    private String uri;
}

package ufrn.br.taskflow.errorhandling;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseStatusExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Erro ao acessar a URI");

        for (var f : e.getConstraintViolations()) {
            body.put(f.getPropertyPath().toString(), f.getMessage());
        }
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Erro ao acessar a URI");
        body.put("error", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}

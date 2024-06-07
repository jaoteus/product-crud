package product.product_crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> productNotFound(ProductNotFoundException e) {
        Map<String, String> response = new HashMap<String, String>(Map.of("message", e.getMessage()));
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        Map<String, String> response = new HashMap<String, String>(Map.of("message", e.getMessage()));
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> categoryNotFoundException(CategoryNotFoundException e) {
        Map<String, String> response = new HashMap<String, String>(Map.of("message", e.getMessage()));
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryIsAlreadyInTheProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> categoryIsAlreadyInTheProjectException(CategoryIsAlreadyInTheProductException e) {
        Map<String, String> response = new HashMap<>(Map.of("message", e.getMessage()));
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundOnThisProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> categoryIsNotInTheProductException(CategoryNotFoundOnThisProductException e) {
        Map<String, String> response = new HashMap<>(Map.of("message", e.getMessage()));
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
    }
}

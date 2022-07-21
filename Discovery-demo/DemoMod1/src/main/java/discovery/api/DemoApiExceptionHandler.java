package discovery.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DemoApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exception() {
        return new ResponseEntity<String>("Something went wrong. Please try again later.",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

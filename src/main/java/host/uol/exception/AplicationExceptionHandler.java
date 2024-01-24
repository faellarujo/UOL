package host.uol.exception;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class AplicationExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity responseEntity1(Exception e) {
        log.info("Erro durante o processamento JSON: {}", e.getMessage());
        return new ResponseEntity("Erro durante o processamento JSON: {}", HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity responseEntity(Exception e) {
        log.info("Caiu na exception" + e.getMessage());
        return new ResponseEntity("Error de NullPointerException", HttpStatus.BAD_GATEWAY);
    }
}

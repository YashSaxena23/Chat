package backend.Exception;

import backend.Utils.Logging;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<String> userNotFoundExceptionImpl(UserNotFoundException ex){
        Logging.logPapertrail.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserAlreadyRegisteredException.class})
    public ResponseEntity<String> userAlreadyExistsImpl(UserAlreadyRegisteredException ex){
        Logging.logPapertrail.error(ex.getMessage());
        return new
                ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }


}

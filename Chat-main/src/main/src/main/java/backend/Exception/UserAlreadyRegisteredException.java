package backend.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User already registered")
public class UserAlreadyRegisteredException extends Exception{
    public UserAlreadyRegisteredException(String message,Throwable cause){
        super(message, cause);
    }
    public UserAlreadyRegisteredException(){

    }
}

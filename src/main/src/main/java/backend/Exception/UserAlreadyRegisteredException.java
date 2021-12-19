package backend.Exception;

public class UserAlreadyRegisteredException extends RuntimeException{
    public UserAlreadyRegisteredException(String errMsg){
        super(errMsg);
    }
}

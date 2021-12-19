package backend.Controller;

import backend.Entities.User;
import backend.Exception.UserAlreadyRegisteredException;
import backend.Repositories.UserRepository;
import backend.Utils.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup/user/email")
    public ResponseEntity<String> signUpEmail(@RequestParam String email,@RequestBody User user){
        try{
            Logging.getUrl();
            User user1 = userRepository.getUserByEmail(email);
            if(user1 != null){
                throw new UserAlreadyRegisteredException("User already registered");
            }else{
                user1 = new User(user.getId(), user.getUserName(), user.getMobile(), user.getEmail(), user.getProfilePic(),
                        user.getIsActive(), user.getUserGender(), user.getFirstName(), user.getMiddleName(), user.getLastName(),
                        user.getCountryCode(), user.getInfo(), user.getCreationTime(), null,user.getAddress(),null,null);
                userRepository.save(user1);
            }
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}

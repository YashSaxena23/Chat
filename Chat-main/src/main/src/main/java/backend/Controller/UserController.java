package backend.Controller;

import backend.Entities.User;
import backend.Service.UserService;
import backend.Utils.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestParam(required = false) String email,@RequestParam(required = false) String mobile,
                                             @RequestParam(required = false) String name){
        Logging.getUrl();
        String user = userService.createOrder(email,mobile,name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * you can pass either mobile,email or id of the user, and the fields can be updated.
     * @param mobile
     * @param email
     * @param id
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<String> updateUserProfile(@RequestBody User user, @RequestParam(required = false) Long id,
                                                    @RequestParam(required = false) String mobile,
                                                    @RequestParam(required = false) String email){
        Logging.getUrl();
        String user1 = userService.updateUser(user,id,mobile,email);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
}

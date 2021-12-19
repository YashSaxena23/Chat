package backend.Service;

import backend.Entities.User;
import backend.Exception.UserNotFoundException;
import backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createOrder(String email, String mobile, String name) {
        User user = new User();
        if(email != null) {
            user = userRepository.getUserByEmail(email);
        }else
            user = userRepository.getUserByMobile(mobile);
        if (user == null){
            user = new User();
            user.setEmail(email);
            user.setMobile(mobile);
            user.setUserName(name);
            user.setIsActive(true);
            userRepository.save(user);
        }
        return user.toString();
    }

    @Override
    public String updateUser(User u, Long id, String mobile, String email){
        User user = new User();
        if(mobile != null){
            user = userRepository.getUserByMobile(mobile);
        }else if(email != null){
            user = userRepository.getUserByEmail(email);
        }else if(id != null){
            user = userRepository.getById(id);
        }
        if(user == null){
            throw new UserNotFoundException("User Not Found");
        }else{
            user.setUserGender(u.getUserGender());
            user.setUserName(u.getUserName());
            user.setEmail((u.getEmail() == null) ? email : u.getEmail());
            user.setMobile((u.getMobile() == null) ? mobile : u.getMobile());
            user.setProfilePic(u.getProfilePic());
            user.setIsActive(true);
            user.setCountryCode(u.getCountryCode());
            user.setFirstName(u.getFirstName());
            user.setMiddleName(u.getMiddleName());
            user.setLastName(u.getLastName());
            user.setUpdateTime(System.currentTimeMillis());
            userRepository.save(user);
            return user.toString();
        }
    }
}

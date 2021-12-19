package backend.Service;

import backend.Entities.User;

public interface UserService {
    String createOrder(String email, String mobile, String name);

    String updateUser(User user,Long id,String mobile,String email);
}

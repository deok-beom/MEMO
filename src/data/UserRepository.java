package Miniproject2.src.data;


import Miniproject2.src.application.Entity.User;
import Miniproject2.src.application.Exception.UserNotFoundException;

public interface UserRepository {
    void saveUser(User user);
    User findUser(String loginId) throws UserNotFoundException;
}

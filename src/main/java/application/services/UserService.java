package application.services;

import application.models.user.Role;
import application.models.user.User;
import application.models.user.UserResponse;
import application.repositories.UserRepository;
import io.github.thibaultmeyer.cuid.CUID;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User findOneById(String id) throws Exception {
        if (!CUID.isValid(id)) {
           throw new Exception("invalid_user_id");
        }
        User user = this.userRepository.findOneById(id);
        if (user == null) {
           throw new Exception("user_not_found");
        }
        return user;
    }
}

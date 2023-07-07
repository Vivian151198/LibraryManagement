package application.services;

import application.models.user.User;
import application.models.user.UserResponse;
import application.repositories.UserRepository;
import io.github.thibaultmeyer.cuid.CUID;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public UserResponse findOneById(String id) {
        if (!CUID.isValid(id)) {
            return null;
        }
        User user = this.userRepository.findOneById(id);
        if (user == null) {
            return null;
        }
        return new UserResponse(user.getId().toString(), user.getName(), user.getRole());
    }
}

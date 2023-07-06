package application.services;

import application.models.user.User;
import application.repositories.UserRepository;
import io.github.thibaultmeyer.cuid.CUID;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User findOneById(String id) {
        if(CUID.isValid(id)) {
            return this.userRepository.findOneById(id);
        }
        return null;
    }
}

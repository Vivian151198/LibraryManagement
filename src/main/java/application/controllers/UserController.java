package application.controllers;

import application.models.user.User;
import application.models.user.UserResponse;
import application.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @GetMapping("/find")
    public UserResponse findOneById(@RequestParam("id") String id) throws Exception {
        UserResponse userResponse;
       try{
          User user =  userService.findOneById(id);
          userResponse = new UserResponse(user.getId().toString(), user.getName(), user.getRole());

       }catch (Exception e){
           return null;
       }
       return userResponse;
    }

}

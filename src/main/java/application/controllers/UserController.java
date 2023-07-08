package application.controllers;

import application.models.user.User;
import application.models.user.UserData;
import application.models.user.UserResponse;
import application.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
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
          UserData userData = new UserData(user.getId().toString(), user.getName(), user.getRole());
          userResponse = new UserResponse("success", null, userData);

       }catch (Exception e){
           return new UserResponse("failed", e.getMessage(), null);
       }
       return userResponse;
    }

}

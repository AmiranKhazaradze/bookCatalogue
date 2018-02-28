package api.bookcatalogue.resource;

import api.bookcatalogue.model.User;
import api.bookcatalogue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@RequestMapping(path = "/api")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;


    @PostMapping(value = "/login")
    public User login(@RequestBody final User user,HttpSession httpSession){
        User loginedUser = this.userRepository.findByEmail(user.getEmail());
        if(loginedUser != null && loginedUser.getPassword().equals(user.getPassword())){
            this.httpSession = httpSession;
            this.httpSession.setAttribute("user",user);
            return user;
        }
        return  null;
    }

}

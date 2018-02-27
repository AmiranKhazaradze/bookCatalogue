package api.bookcatalogue.resource;

import api.bookcatalogue.model.User;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
public class LoginController {

    @PostMapping(value = "/login")
    public User login(@RequestBody final User user){

        System.out.println(user);
        return  null;
    }

}

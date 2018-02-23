package api.bookcatalogue.resource;

import api.bookcatalogue.model.User;
import api.bookcatalogue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/login")
    public User login(@RequestBody final User user){
        User tmp = findUserInDatabase(user);
        if(tmp != null){
            return tmp;
        }else{
            System.out.println("not found");
        }
        return  user;
    }

    private User findUserInDatabase(User user){
        Iterator<User> iterator =  this.userRepository.findAll().iterator();
        while (iterator.hasNext()) {
            User tmp = iterator.next();
            if (tmp.getEmail().equals(user.getEmail())) {
                return tmp;
            }
        }
        return null;
    }

}

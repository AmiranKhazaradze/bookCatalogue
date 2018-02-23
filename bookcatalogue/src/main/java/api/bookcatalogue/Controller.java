package api.bookcatalogue;

import api.bookcatalogue.model.Book;
import api.bookcatalogue.model.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3601)
@RestController
public class Controller {

    @PostMapping("/post")
    public void   post(@RequestBody User user){
        System.out.println(user.getEmail()+" "+user.getPassword());
    }

    @GetMapping("/get")
    public String get(){
        return "get";
    }


}

package api.bookcatalogue.resource;

import api.bookcatalogue.model.Book;
import api.bookcatalogue.model.User;
import api.bookcatalogue.repository.BookRepository;
import api.bookcatalogue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @PostMapping(value = "/login")
    public List<Book> login(@RequestBody final User user){
        User tmp = findUserInDatabase(user);
        if(tmp != null){
            if(user.getPassword().equals(tmp.getPassword()))
                return this.bookRepository.findAll();
        }
        return  null;
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

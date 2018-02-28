package api.bookcatalogue.resource;

import api.bookcatalogue.model.Book;
import api.bookcatalogue.model.User;
import api.bookcatalogue.repository.BookRepository;
import api.bookcatalogue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@RequestMapping(path = "/api")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping(value = "/home")
    public List<Book> home(){
        return this.bookRepository.findAll();
    }

    @GetMapping(value = "/getFavorites")
    public List<Book> getFavorite(){

        User user = (User) this.httpSession.getAttribute("user");

        return new ArrayList<>(this.userRepository.findOne(
                this.userRepository.findByEmail(user.getEmail()).getId()).getBooks());
    }

    @PostMapping(value = "/addFavorite")
    public void addFavorite(@RequestBody final Book book){
        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepository.findOne(this.userRepository.findByEmail(tmp.getEmail()).getId());
        user.getBooks().add(book);
        this.userRepository.save(user);
    }

    @PostMapping(value = "/deleteFavorite")
    public void deleteFavorite(@RequestBody final Book book){
        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepository.findOne(this.userRepository.findByEmail(tmp.getEmail()).getId());
        user.getBooks().remove(book);
        this.userRepository.save(user);
    }

    @PostMapping(value = "/favoriteBookIsAdded")
    public boolean favoriteBookIsAdded(@RequestBody final Book book){
        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepository.findOne(this.userRepository.findByEmail(tmp.getEmail()).getId());
        if(user.getBooks().contains(book))
            return true;
        return false;
    }

}

package api.bookcatalogue.resource;

import api.bookcatalogue.model.Book;
import api.bookcatalogue.model.User;
import api.bookcatalogue.repository.BookRepository;
import api.bookcatalogue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/home")
    public List<Book> home(){
        return this.bookRepository.findAll();
    }

    @GetMapping(value = "/getFavorites")
    public List<Book> getFavorite(){
         return new ArrayList<>(this.userRepository.findOne(1).getBooks());
    }

    @PostMapping(value = "/addFavorite")
    public void addFavorite(@RequestBody final Book book){
        User user = this.userRepository.findOne(1);
        user.getBooks().add(book);
        this.userRepository.save(user);
    }

}

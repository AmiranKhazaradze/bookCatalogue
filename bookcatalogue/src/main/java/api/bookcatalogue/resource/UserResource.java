package api.bookcatalogue.resource;

import api.bookcatalogue.model.Administrator;
import api.bookcatalogue.model.Book;
import api.bookcatalogue.model.BookPopularity;
import api.bookcatalogue.model.User;
import api.bookcatalogue.repository.AdministratorRepositore;
import api.bookcatalogue.repository.BookRepository;
import api.bookcatalogue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    AdministratorRepositore administratorRepositore;

    @PersistenceContext
    EntityManager entityManager ;

    @Autowired
    HttpSession httpSession;

    @GetMapping(value = "/home")
    public List<Book> home(){
        return this.bookRepository.findAll();
    }

    @GetMapping(value = "/getFavorites")
    public List<Book> getFavorite(){

        User user = (User) this.httpSession.getAttribute("user");
        return new ArrayList<>((this.userRepository.findByEmail(user.getEmail()).getBooks()));
    }

    @PostMapping(value = "/addFavorite")
    public void addFavorite(@RequestBody final Book book){
        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepository.findByEmail(tmp.getEmail());
        user.getBooks().add(book);
        this.userRepository.save(user);
    }

    @PostMapping(value = "/deleteFavorite")
    public void deleteFavorite(@RequestBody final Book book){
        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepository.findByEmail(tmp.getEmail());
        user.getBooks().remove(book);
        this.userRepository.save(user);
    }

    @PostMapping(value = "/favoriteBookIsAdded")
    public boolean favoriteBookIsAdded(@RequestBody final Book book){
        User tmp = (User) this.httpSession.getAttribute("user");
        User user = this.userRepository.findByEmail(tmp.getEmail());
        if(user.getBooks().contains(book))
            return true;
        return false;
    }

    @PostMapping(value = "/isAdmin")
    public boolean isAdmin(@RequestBody final Administrator administrator){
        Administrator tmp = this.administratorRepositore.findByEmail(administrator.getEmail());
        if(tmp != null){
            if(tmp.getPassword().equals(administrator.getPassword())) {
                return true;
            }
        }
        return false;
    }


    @GetMapping(value = "/getBooksPopularity")
    public List<BookPopularity> getBookPopularity(){
//        List<BookPopularity> bookPopularityList = new ArrayList<>();
//        Iterator<Book> bookIterator = this.bookRepository.findAll().iterator();
//        while (bookIterator.hasNext()){
//            int popularity = 0;
//            Book currentBook = bookIterator.next();
//            Iterator<User> userIterator = this.userRepository.findAll().iterator();
//            while (userIterator.hasNext()){
//                User currentUser = userIterator.next();
//                if(currentUser.getBooks().contains(currentBook))
//                    ++popularity;
//            }
//            BookPopularity tmp = new BookPopularity(
//                    currentBook.getId(),currentBook.getName(),currentBook.getAuthor(),popularity);
//            bookPopularityList.add(tmp);
//        }

        List<BookPopularity> bookPopularityList = new ArrayList<>();
        javax.persistence.Query query = this.entityManager.createQuery(
                "SELECT book.m_name, book.m_author, count(book.id)  from Book book " +
                "join ", BookPopularity.class);
        for (Object o : query.getResultList()){

//            BookPopularity tmp = new BookPopularity();
        }

        System.out.printf(query.getResultList().toString());
        return query.getResultList();

//        bookPopularityList.sort(((o1, o2) -> o2.getPopularity()-o1.getPopularity()));
//
//        return bookPopularityList;
    }

}

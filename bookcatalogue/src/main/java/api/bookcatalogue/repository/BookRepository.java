package api.bookcatalogue.repository;

import api.bookcatalogue.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}

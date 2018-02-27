package api.bookcatalogue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users", schema = "book_database")
public class User  {

    @Id
    @GeneratedValue
    @Column(name ="id")
    private int id;
    @Column(name ="m_name")
    private String name;
    @Column(name ="m_surname")
    private String surname;
    @Column(name ="m_email")
    private String email;
    @Column(name ="m_password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_favorite_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

    public Set<Book> getBooks(){
        return books;
    }

    public void setBooks(Set<Book> books){
        this.books = books;
    }


}

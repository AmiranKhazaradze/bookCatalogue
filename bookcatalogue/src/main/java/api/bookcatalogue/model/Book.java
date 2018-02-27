package api.bookcatalogue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "books", schema = "book_database")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "m_name")
    private String name;
    @Column(name = "m_author")
    private String author;
    @Column(name = "m_year")
    private String year;
    @Column(name = "isbn")
    private String ISBN;

//    @ManyToMany(mappedBy = "books")
//    private List<User> users;




}

package api.bookcatalogue.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books", schema = "book_database" +
        "")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "m_name")
    private String name;
    @Column(name = "m_author")
    private String author;
    @Column(name = "m_year")
    private String year;
    @Column(name = "ISBN")
    private String ISBN;

}

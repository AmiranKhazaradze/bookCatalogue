package api.bookcatalogue.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "administrators", schema = "book_database")
public class Administrator {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "m_email")
    private String email;
    @Column(name = "m_password")
    private String password;
}

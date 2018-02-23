package api.bookcatalogue.model;

import javax.persistence.*;
import java.io.Serializable;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

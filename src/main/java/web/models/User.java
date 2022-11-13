package web.models;


import javax.persistence.*;

@Table(name = "users")
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String last_name;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String name, String last_name, String email) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public User(Long id, String name, String last_name, String email) {
        this(name, last_name, email);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

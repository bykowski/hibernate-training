package src.model;

import javax.persistence.*;

@Entity
@Table(name = "notepads")
public class NotePad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NotePad() {
    }

    public NotePad(String brand) {
        this.title = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

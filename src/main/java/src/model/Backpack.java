package src.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "backpacks")
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String brand;

    @OneToMany
    @JoinColumn(name = "backpack_id")
    private Set<NotePad> notePadSet;

    public Set<NotePad> getNotePadSet() {
        return notePadSet;
    }

    public void setNotePadSet(Set<NotePad> notePadSet) {
        this.notePadSet = notePadSet;
    }

    public Backpack() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

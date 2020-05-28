package src.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;

    @Column(name = "grup_id")
    @Enumerated
    private GrupId grupId;

    @OneToOne
    private Backpack backpack;


    @ManyToMany(mappedBy = "studentSet")
    private Set<Professor> professorSet;

    public Student() {
    }

    public Student(String name, String surname, GrupId grupId) {
        this.name = name;
        this.surname = surname;
        this.grupId = grupId;
    }

    public Set<Professor> getProfessorSet() {
        return professorSet;
    }

    public void setProfessorSet(Set<Professor> professorSet) {
        this.professorSet = professorSet;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public GrupId getGrupId() {
        return grupId;
    }

    public void setGrupId(GrupId grupId) {
        this.grupId = grupId;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grupId=" + grupId +
                '}';
    }
}

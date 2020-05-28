package src;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(String name, String surname, GrupId grupId, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.grupId = grupId;
        this.dateOfBirth = dateOfBirth;
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

package src;

import src.model.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // DTO
        Dao<Backpack> backpackDao = new Dao<>();
        Dao<Student> studentDao = new Dao<>();
        Dao<NotePad> notePadDao = new Dao<>();
        Dao<Professor> professorDao = new Dao<>();

        // NOTEPAD CREATE
        NotePad notePadMath = new NotePad();
        notePadMath.setTitle("Math");
        notePadDao.save(notePadMath);

        NotePad notePadPhysics = new NotePad();
        notePadPhysics.setTitle("Physics");
        notePadDao.save(notePadPhysics);

        // BACKPACK CREATE
        Backpack backpackNike = new Backpack();
        backpackNike.setBrand("Nike");
        backpackNike.setNotePadSet(Stream.of(notePadMath, notePadPhysics).collect(Collectors.toSet()));
        backpackDao.save(backpackNike);

        Backpack backpackPuma = new Backpack();
        backpackPuma.setBrand("Puma");
        backpackDao.save(backpackPuma);

        // STUDENT CREATE
        Student studentPrzemek = new Student("Przemek", "Bykowski", GrupId.NCI_115);
        studentPrzemek.setBackpack(backpackNike);

        Student studentAnna = new Student("Anna", "Nowak", GrupId.NCI_135);
        studentAnna.setBackpack(backpackPuma);

        // PROFESSOR CREATE
        Professor professorKarol = new Professor("Karol", "Kowalski", "Ph.D");
        Professor professorKarolina = new Professor("Karolina", "Wiśniewska", "Professor");

        //useless
//        studentPrzemek.setProfessorSet(Stream.of(professorKarol, professorKarolina).collect(Collectors.toSet()));
//        studentAnna.setProfessorSet(Stream.of(professorKarol).collect(Collectors.toSet()));

        professorKarol.setStudentSet(Stream.of(studentPrzemek, studentAnna).collect(Collectors.toSet()));
        professorKarolina.setStudentSet(Stream.of(studentAnna).collect(Collectors.toSet()));

        studentDao.save(studentPrzemek);
        studentDao.save(studentAnna);

        professorDao.save(professorKarol);
        professorDao.save(professorKarolina);

    }
}

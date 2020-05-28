package src;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        studentDao.save(new Student("Anna", "Nowak", GrupId.NCI_125, LocalDate.of(2000, 11, 11)));
        System.out.println(studentDao.get(1L));
        studentDao.save(new Student("Przemek", "Bykowski", GrupId.NCI_125, LocalDate.of(2000, 11, 11)));
        studentDao.delete(1L);
        studentDao.update(2L, new Student("Przemek", "Bykowski", GrupId.NCI_135, LocalDate.of(2000, 11, 11)));
        System.out.println(studentDao.get(2L));
    }
}

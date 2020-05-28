package src;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class StudentDao {

    public Student get(Long id) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public void save(Student student) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(student);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();
    }

    public void update(Long id, Student newStudent) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            Student student = session.get(Student.class, id);
            student.setName(newStudent.getName());
            student.setSurname(newStudent.getSurname());
            student.setGrupId(newStudent.getGrupId());
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();
    }


    public void delete(Long id) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            Student student = session.get(Student.class, id);
            session.delete(student);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();
    }
}

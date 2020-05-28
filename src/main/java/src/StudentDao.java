package src;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public Student get(Long id) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public void save() {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(new Student(1L, "Przemek", "Bykowski"));
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();
    }
}

package src;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Dao<T> {

    Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
    Transaction transaction = session.getTransaction();

    public void save(T elment) {
        transaction.begin();
        try {
            session.save(elment);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }
}

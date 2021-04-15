package xyz.merccurion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ContactDao {
    
    Util util = new Util();

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public void addContact(Contact contact) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.save(contact);
        transaction.commit();

        session.close();
    }

    public void updateContact(Contact contact) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.update(contact);
        transaction.commit();

        session.close();
    }
}
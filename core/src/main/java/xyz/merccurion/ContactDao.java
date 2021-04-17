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

    public Contact getContact(int id) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        Contact contact = (Contact) session.get(Contact.class, id);

        transaction.commit();
        session.close();
        return contact;
    }

    public void deleteContact(Contact contact) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.delete(contact);
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
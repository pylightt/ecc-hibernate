package xyz.merccurion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RolesDao {
    
    Util util = new Util();

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public void addRole(Roles role) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.save(role);
        transaction.commit();

        session.close();
    }

    public void deleteRole(Roles role) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.delete(role);
        transaction.commit();
        session.close();
    }

    public Roles getRole(int id) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        Roles role = (Roles) session.get(Roles.class, id);
       
        transaction.commit();
        session.close();
        return role;
    }

    public void updateRole(Roles role) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.update(role);
        transaction.commit();

        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Roles> listRoles() {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        List<Roles> rolesList = (List<Roles>) session.createQuery("FROM Roles").list();
        transaction.commit();
        session.close();
        return rolesList;
    }
}
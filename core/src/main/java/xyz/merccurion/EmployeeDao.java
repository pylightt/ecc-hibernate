package xyz.merccurion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDao {
    
    Util util = new Util();

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public void addEmployeeDetails(Employee employee) {
        factory = util.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        session.save(employee);
        transaction.commit();

        session.close();
    }

    public void addRoles(Roles roles) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.save(roles);
        transaction.commit();

        session.close();
    }

    public Employee getEmployee(int id) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class, id);
       
        transaction.commit();
        session.close();
        return employee;
    }

    public void deleteEmployee(Employee employee) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.delete(employee);
        transaction.commit();
        session.close();
    }

    public void updateEmployee(Employee employee) {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        session.update(employee);
        transaction.commit();

        session.close();
    }
}
package xyz.merccurion;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManageEmployee {
    Util util = new Util();

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public Integer addEmployee(Employee employee, Set<Roles> roles) {
        factory = util.getSessionFactory();
        session = factory.openSession();
        // transaction = null;
        Integer employeeID = null;
        
       
        transaction = session.beginTransaction();
        // employee.setRoles(roles);
        //employeeID = (Integer) 
        session.save(employee);
        transaction.commit();

        session.close();
    
        return employeeID;
    }
    

}
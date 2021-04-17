package xyz.merccurion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDao {
    
    Util util = new Util();

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public void addEmployee(Employee employee) {
        factory = util.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        session.save(employee);
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

    @SuppressWarnings("unchecked")
    public List<Employee> listEmployee() {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        List<Employee> employeeList = (List<Employee>) session.createQuery("FROM Employee").list();
        transaction.commit();
        session.close();
        return employeeList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> listEmployeeByHireDate() {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        List<Employee> employeeList = (List<Employee>) session.createQuery("FROM Employee e ORDER BY e.other.hireDate DESC").list();
        transaction.commit();
        session.close();
        return employeeList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> listEmployeeByLastname() {
        factory = util.getSessionFactory();
        session = factory.openSession();           
        transaction = session.beginTransaction();

        List<Employee> employeeList = (List<Employee>) session.createQuery("FROM Employee e ORDER BY e.name.lastName ASC").list();
        transaction.commit();
        session.close();
        return employeeList;
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
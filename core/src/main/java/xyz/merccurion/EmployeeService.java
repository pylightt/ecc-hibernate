package xyz.merccurion;

public class EmployeeService {
    
    Util util = new Util();

    public Employee addEmployeeDetails() {
        // String lastName = util.getString("Last Name: ");
        // String firstName = util.getString("First Name: ");
        // String middleName = util.getString("Middle Name: ");
        // String suffix = util.getString("Suffix: ");
        // String title = util.getString("Title: ");
        // Name name = new Name(lastName,firstName,middleName,suffix,title);

        // String streetNo = util.getString("Street No.: ");
        // String barangay = util.getString("Barangay: ");
        // String city = util.getString("City: ");
        // int zip = util.getInt("Zip: ");
        // Address address = new Address(streetNo,barangay,city,zip);

        // String birthday = util.getString("Birthday (MM/DD/YYYY): ");
        // double gwa = util.getDouble("GWA: ");
        // String hireDate = util.getString("Hire date (MM/DD/YYYY): ");
        // boolean isHired = util.getBoolean("Currently employed? (Y/N): ");
        // Other other = new Other(birthday,gwa,hireDate,isHired);

        // Employee employee = new Employee(name,address,other);

        // return employee;       

        String lastName = "Lacson";
        String firstName = "Jann Ily";
        String middleName = "Gabriel";
        String suffix = "";
        String title = "Engr.";
        Name name = new Name(lastName,firstName,middleName,suffix,title);
        String streetNo = "86";
        String barangay = "Tonsuya";
        String city = "Malabon";
        int zip = 1473;
        Address address = new Address(streetNo,barangay,city,zip);
        String birthday = "01/08/1998";
        double gwa = 2.15;
        String hireDate = "04/12/2021";
        boolean isHired = true;
        Other other = new Other(birthday,gwa,hireDate,isHired);
        Employee employee = new Employee(name,address,other);
        
        return employee;
    }

    public void addEmployee(Employee employee) {
        EmployeeDao eDao = new EmployeeDao();
        eDao.addEmployeeDetails(employee);
    }

    public void updateEmployee(Employee employee) {
        EmployeeDao eDao = new EmployeeDao();
        eDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        EmployeeDao eDao = new EmployeeDao();
        Employee employee = eDao.getEmployee(id);
        eDao.deleteEmployee(employee);
    }

    public Employee getEmployee(int id) {
        EmployeeDao eDao = new EmployeeDao();
        Employee employee = eDao.getEmployee(id);
        return employee;
    }
}
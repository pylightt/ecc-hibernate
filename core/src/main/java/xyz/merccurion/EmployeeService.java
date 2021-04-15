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

    public Employee updateEmployeeDetails(Employee employee, int id) {
        String update;
        Name updateName = employee.getName();
        Address updateAddress = employee.getAddress();
        Other updateOther = employee.getOther();
        switch(id) {
            case 1: // lastname
            update = util.getString("Updated last name: ");
            updateName.setLastName(update);
            employee.setName(updateName);
            break;

            case 2: // firstname
            update = util.getString("Updated first name: ");
            updateName.setFirstName(update);
            employee.setName(updateName);
            break;

            case 3: // middlename
            update = util.getString("Updated middle name: ");
            updateName.setMiddleName(update);
            employee.setName(updateName);
            break;

            case 4: // suffix
            update = util.getString("Updated suffix: ");
            updateName.setSuffix(update);
            employee.setName(updateName);
            break;

            case 5: // title
            update = util.getString("Updated title: ");
            updateName.setTitle(update);
            employee.setName(updateName);
            break;

            case 6: // street no
            update = util.getString("Updated street no.: ");
            updateAddress.setStreetNo(update);
            employee.setAddress(updateAddress);;
            break;

            case 7: // barangay
            update = util.getString("Updated barangay: ");
            updateAddress.setBarangay(update);
            employee.setAddress(updateAddress);
            break;

            case 8: // city
            update = util.getString("Updated city: ");
            updateAddress.setBarangay(update);
            employee.setAddress(updateAddress);
            break;

            case 9: // zip
            int updateInt = util.getInt("Updated zip code: ");
            updateAddress.setZip(updateInt);
            employee.setAddress(updateAddress);
            break;

            case 10: // birthday
            update = util.getString("Updated birthday (MM/DD/YYYY): ");
            updateOther.setBirthday(update);
            employee.setOther(updateOther);
            break;

            case 11: // gwa
            double updateDouble = util.getDouble("Updated GWA: ");
            updateOther.setGwa(updateDouble);
            employee.setOther(updateOther);
            break;

            case 12: // hire date
            update = util.getString("Updated hire date (MM/DD/YYYY(: ");
            updateOther.setHireDate(update);
            employee.setOther(updateOther);
            break;

            case 13: // employment status
            boolean updateBool = util.getBoolean("Currently employed? (Y/N): ");
            updateOther.setIsHired(updateBool);
            employee.setOther(updateOther);
            break;

        }
        EmployeeDao eDao = new EmployeeDao();
        eDao.updateEmployee(employee);

        return employee;
    }
}
package xyz.merccurion;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    
    Util util = new Util();

    public Employee addEmployeeDetails() {
        String lastName = util.getString("Last Name: ");
        String firstName = util.getString("First Name: ");
        String middleName = util.getString("Middle Name: ");
        String suffix = util.getString("Suffix: ");
        String title = util.getString("Title: ");
        Name name = new Name(lastName,firstName,middleName,suffix,title);

        String streetNo = util.getString("Street No.: ");
        String barangay = util.getString("Barangay: ");
        String city = util.getString("City: ");
        int zip = util.getInt("Zip: ");
        Address address = new Address(streetNo,barangay,city,zip);

        String birthday = util.getString("Birthday (YYYY/MM/DD): ");
        double gwa = util.getDouble("GWA: ");
        String hireDate = util.getString("Hire date (YYYY/MM/DD): ");
        boolean isHired = util.getBoolean("Currently employed? (Y/N): ");
        Other other = new Other(birthday,gwa,hireDate,isHired);

        Employee employee = new Employee(name,address,other);
        
        return employee;
    }

    public void addEmployee(Employee employee) {
        EmployeeDao eDao = new EmployeeDao();
        eDao.addEmployee(employee);
    }

    public Employee getEmployee(int id) {
        EmployeeDao eDao = new EmployeeDao();
        Employee employee = eDao.getEmployee(id);
        return employee;
    }

    public void deleteEmployee(int id) {
        EmployeeDao eDao = new EmployeeDao();
        Employee employee = eDao.getEmployee(id);
        eDao.deleteEmployee(employee);
    }

    public List<Employee> listEmployee() {
        EmployeeDao eDao = new EmployeeDao();
        List<Employee> employeeList = eDao.listEmployee();
        return employeeList;
    }

    public List<Employee> listEmployeeByHireDate() {
        EmployeeDao eDao = new EmployeeDao();
        List<Employee> employeeListByHireDate = new ArrayList<Employee>();
        employeeListByHireDate = eDao.listEmployeeByHireDate();
        
        return employeeListByHireDate ;
    }

    public List<Employee> listEmployeeByLastname() {
        EmployeeDao eDao = new EmployeeDao();
        List<Employee> employeeListByLastname = new ArrayList<Employee>();
        employeeListByLastname = eDao.listEmployeeByLastname();
        
        return employeeListByLastname ;
    }

    public void updateEmployee(Employee employee) {
        EmployeeDao eDao = new EmployeeDao();
        eDao.updateEmployee(employee);
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
            update = util.getString("Updated birthday (YYYY/MM/DD): ");
            updateOther.setBirthday(update);
            employee.setOther(updateOther);
            break;

            case 11: // gwa
            double updateDouble = util.getDouble("Updated GWA: ");
            updateOther.setGwa(updateDouble);
            employee.setOther(updateOther);
            break;

            case 12: // hire date
            update = util.getString("Updated hire date (YYYY/MM/DD): ");
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
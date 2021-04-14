package xyz.merccurion;

public class MEService {
    
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

        String birthday = util.getString("Birthday (MM/DD/YYYY): ");
        double gwa = util.getDouble("GWA: ");
        String hireDate = util.getString("Hire date (MM/DD/YYYY): ");
        boolean isHired = util.getBoolean("Currently employed? (Y/N): ");
        Other other = new Other(birthday,gwa,hireDate,isHired);

        String landline = util.getString("Landline: ");
        String mobile = util.getString("Mobile: ");
        String email = util.getString("email: ");
        Contact contact = new Contact(landline,mobile,email);

        Employee employee = new Employee(name,address,other,contact);

        return employee;       
    }

    public Roles addEmployeeRoles() {
        Roles roles = new Roles(util.getString("(Enter 'e' to finish adding roles)\nAdd role: "));
            
        return roles;
    }

}
package xyz.merccurion;

public class Main {
    public static void main(String[] args) {

        while(true) {
            chooseMenu();
        }
    }

    static void chooseMenu() {

        Util util = new Util();
        
        menuOptions();

        int choose = util.getInt("Option: ");
        if((choose > 0 && choose < 15)) {
            menu(choose);
        } else {
            System.out.println("Invalid input.");
        }
    }

    static void menu(int choose) {
        EmployeeService eService = new EmployeeService();
        EmployeeDao eDao = new EmployeeDao();
        ContactService cService = new ContactService();
        ContactDao cDao = new ContactDao();
        RolesService rService = new RolesService();
        RolesDao rDao = new RolesDao();

        Util util = new Util();

        switch(choose) {
            case 1: // create employee
                Employee employee = eService.addEmployeeDetails(); 
                eService.addEmployee(employee);

                Contact contact = cService.addContactDetails();
                contact.setEmployee(employee);
                employee.getContact().add(contact);
                cService.addContact(contact);
                eDao.updateEmployee(employee);

                Roles role = new Roles();
                do {
                    role =  rService.addRoleDetails();
                    if (role.getRole().equalsIgnoreCase("e")) break;
                    employee.getRoles().add(role);
                    rService.addRole(role);
                } while (!role.getRole().equalsIgnoreCase("e"));
                eDao.updateEmployee(employee);
                break;

            case 2: // delete employee
                int deleteId = util.getInt("Enter employee's id for deletion: ");
                try {
                    eService.deleteEmployee(deleteId);
                } catch(Exception e) {}
                break;

            case 3: // update employee
            case 4: // list employees
            case 5: // add employee role
            case 6: // delete employee role
            case 7: // add contact
            case 8: // update contact
            case 9: // delte contact
            case 10: // add role
            case 11: // update role
            case 12: // delete role
            case 13: // list role

            case 14: // exit menu
                System.exit(0);
        
            
                

        }
    }
    

    static void menuOptions() {
        String text = 
            " 1: Create Employee\n" +
            " 2: Delete Employee\n" +
            " 3: Update Employee\n" +
            " 4: List Employees\n" +
            " 5: Add Employee Role\n" +
            " 6: Delete Employee Role\n" +
            " 7: Add Contact\n" +
            " 8: Update Contact\n" +
            " 9: Delete Contact\n" +
            "10: Add Role\n" +
            "11: Update Role\n" +
            "12: Delete Role\n" +
            "13: List Role\n" +
            "14: Exit Menu\n\n";
        
        System.out.print(text);
    }
}
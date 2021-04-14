package xyz.merccurion;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        String text = "1: Create Employee\n2: Delete Employee\n3: Update Employee\n4: List Employee\n5: Add Role\n\nOption: ";
        int choose = util.getInt(text);

        MEService service = new MEService();
        ManageEmployee me = new ManageEmployee();
        switch(choose) {
            case 1: // create employee
                Employee employee = service.addEmployeeDetails();
                me.addEmployeeDetails(employee);

                Roles roles = new Roles();

                do {
                    roles = service.addEmployeeRoles();
                    if (roles.getRole().equalsIgnoreCase("e")) break;
                    employee.getRoles().add(roles);
                    me.addRoles(roles);
                    
                } while (!roles.getRole().equalsIgnoreCase("e"));
                me.updateEmployee(employee);
                

        }
    }
    
}
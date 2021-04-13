package xyz.merccurion;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        String text = "1: Create Employee\n2: Delete Employee\n3: Update Employee\n4: List Employee\n5: Add Role\n\nOption: ";
        int choose = util.getInt(text);

        MEService service = new MEService();
        ManageEmployee me = new ManageEmployee();
        switch(choose) {
            case 1:
                Employee employee = service.addEmployeeDetails();
                HashSet<Roles> roles = service.addEmployeeRoles();
                me.addEmployee(employee,roles);

        }
    }
    
}
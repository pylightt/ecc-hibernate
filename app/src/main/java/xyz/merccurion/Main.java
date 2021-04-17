package xyz.merccurion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import java.lang.Double;

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
        ContactService cService = new ContactService();
        RolesService rService = new RolesService();

        Util util = new Util();

        switch(choose) {
            case 1: // create employee
                Employee employee = eService.addEmployeeDetails(); 
                eService.addEmployee(employee);

                Contact contact = cService.addContactDetails();
                contact.setEmployee(employee);
                employee.getContact().add(contact);
                cService.addContact(contact);
                eService.updateEmployee(employee);

                Roles role = new Roles();
                do {
                    role =  rService.addRoleDetails();
                    if (role.getRole().equalsIgnoreCase("e")) break;
                    employee.getRoles().add(role);
                    rService.addRole(role);
                } while (!role.getRole().equalsIgnoreCase("e"));
                eService.updateEmployee(employee);
                break;

            case 2: // delete employee
                int deleteId = util.getInt("Enter employee's id for deletion: ");
                try {
                    eService.deleteEmployee(deleteId);
                } catch(Exception e) {}
                break;

            case 3: // update employee
                int updateId = util.getInt("Enter employee's id to udpate: ");
                employeeUpdateOptions();
                int chooseUpdate = util.getInt("Choose entry to update: ");
                if(chooseUpdate == 14) chooseMenu();
                try {
                    Employee employeeDetails = eService.getEmployee(updateId);
                    eService.updateEmployeeDetails(employeeDetails, chooseUpdate);
                } catch(Exception e) {}
                break;
                
            case 4: // list employees
                listOrderOptions();
                int chooseOrder = util.getInt("Choose list order: ");
                switch (chooseOrder) {
                    case 1: // GWA
                        List<Employee> allEmployeeList = eService.listEmployee();
                        List<Double> gwaList = new ArrayList<Double>();
                        List<Employee> orderedGwaList = new ArrayList<Employee>();
                        for (Employee perEmployee : allEmployeeList) {
                            gwaList.add(perEmployee.getOther().getGwa());
                        }
                        Collections.sort(gwaList);
                        for(Double gwa : gwaList) {
                            for (Employee perEmployee : allEmployeeList) {
                                if (perEmployee.getOther().getGwa().equals(gwa)) {
                                    orderedGwaList.add(perEmployee);
                                }
                            }
                        }
                        printOrderedEmployee(orderedGwaList);
                        break;
                    case 2: // Hire date
                        List<Employee> hireDateList = eService.listEmployeeByHireDate();
                        printOrderedEmployee(hireDateList);
                        break;
                    case 3: // Lastname
                        List<Employee> lastnameList = eService.listEmployeeByLastname();
                        printOrderedEmployee(lastnameList);
                        break;
                    case 4: // exit to menu
                        chooseMenu();
                        break;
                    default: 
                        System.out.println("Try again.");
                        menu(choose);
                }
                break;
            case 5: // add employee role
                int employeeIdAddRole = util.getInt("Enter employee's id to add role to: ");
                int roleId = util.getInt("Enter role id to add to employee: ");
                try {
                    Employee employeeAddRole = eService.getEmployee(employeeIdAddRole);
                    Roles roleToAdd = rService.getRole(roleId);
                    Set<Roles> roleSet = employeeAddRole.getRoles();
                    roleSet.add(roleToAdd);
                    eService.updateEmployee(employeeAddRole);
                } catch(Exception e) {}
                break;

            case 6: // delete employee role
                int employeeIdDeleteRole = util.getInt("Enter employee's id delete role from: ");
                int roleIdToDelete = util.getInt("Enter role id to delete from employee: ");
                try {
                    Employee employeeDeleteRole = eService.getEmployee(employeeIdDeleteRole);
                    Roles roleToDelete = rService.getRole(roleIdToDelete);
                    Set<Roles> roleSetForDelete = employeeDeleteRole.getRoles();
                    roleSetForDelete.remove(roleToDelete);
                    eService.updateEmployee(employeeDeleteRole);
                } catch (Exception e) {}
                break;

            case 7: // add contact
                int employeeIdAddContact =  util.getInt("Enter employee's id to add contact to: ");
                try {
                    Employee employeeAddContact = eService.getEmployee(employeeIdAddContact);
                   
                    Contact contactToAdd =cService.addContactDetails();
                    contactToAdd.setEmployee(employeeAddContact);
                    Set<Contact> contactSet = employeeAddContact.getContact();
                    contactSet.add(contactToAdd);
                    cService.addContact(contactToAdd);
                    eService.updateEmployee(employeeAddContact);

                } catch(Exception e) {
                    System.out.println("Invalid input");
                    e.printStackTrace();
                    menu(choose);
                }
                break;
            case 8: // update contact
                int updateContactId = util.getInt("Enter contact id to update: ");
                try {
                    Contact contactDetails = cService.getContact(updateContactId);

                    contactUpdateOptions();
                    int chooseContactUpdate = util.getInt("Choose entry to update: ");
                    if(chooseContactUpdate == 4) chooseMenu();
                    cService.updateContactDetails(contactDetails, chooseContactUpdate);
                } catch(Exception e) {}
                break;
            case 9: // delete contact
                int deleteContactId = util.getInt("Enter contact id for deletion: ");
                try {
                    cService.deleteContact(deleteContactId);
                } catch (Exception e) {}
                break;

            case 10: // add role
                Roles newRole = new Roles();
                do {
                    newRole =  rService.addRoleDetails();
                    if (newRole.getRole().equalsIgnoreCase("e")) break;
                    rService.addRole(newRole);
                } while (!newRole.getRole().equalsIgnoreCase("e"));
                break;
            case 11: // update role
                int updateRoleId = util.getInt("Enter role id to update: ");
                try {
                    Roles roleDetails = rService.getRole(updateRoleId);
                    rService.updateRole(roleDetails);
                } catch(Exception e) {}
                break;
            case 12: // delete role
                int deleteRoleId = util.getInt("Enter role id for deletion: ");
                try {
                    rService.deleteRole(deleteRoleId);
                } catch (Exception e) {}
                break;
            case 13: // list role
                List<Roles> rolesList = rService.listRoles();
                for(Roles roles : rolesList) {
                    System.out.println("Role ID: " + roles.getRoleid() + 
                                        "\tRole: " + roles.getRole());
                }
                break;
            case 14: // exit menu
                System.exit(0);  
        }
    }
    

    static void menuOptions() {
        String text = "\n" +
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
            "13: List Roles\n" +
            "14: Exit\n";
        
        System.out.println(text);
    }

    static void employeeUpdateOptions() {
        String text = "\n" +
            " 1: Last name\n" +
            " 2: First name\n" +
            " 3: Middle name\n" + 
            " 4: Suffix\n" +
            " 5: Title\n" +
            " 6: Street no.\n" +
            " 7: Barangay\n" +
            " 8: City\n" +
            " 9: Zip code\n" +
            "10: Birthday\n" +
            "11: GWA\n" +
            "12: Hire date\n" +
            "13: Employment status\n\n" +
            "14: Exit to menu\n";

        System.out.println(text);
    }

    static void contactUpdateOptions() {
        String text = "\n" +
                "1: Landline\n" +
                "2: Mobile\n" +
                "3: Email\n\n" +
                "4. Exit to menu\n";

        System.out.println(text);
    }

    static void listOrderOptions() {
        String text = "\n" +
                "1: By GWA\n" +
                "2: By date hired\n" +
                "3: By last name\n\n" +
                "4: Exit to menu\n";

        System.out.println(text);
    }

    static void printOrderedEmployee(List<Employee> employeeList) {
        for(Employee perEmployee : employeeList) {
            System.out.print ("\n\n" + "[id:" +
                                perEmployee.getId() + "] " +
                                perEmployee.getName().getTitle() + " " +
                                perEmployee.getName().getLastName() + ", " +
                                perEmployee.getName().getFirstName() + " " +
                                perEmployee.getName().getMiddleName() + " " +
                                perEmployee.getName().getSuffix() + "\n\t" +
                                "Address: " +
                                perEmployee.getAddress().getStreetNo()  + " " +
                                perEmployee.getAddress().getBarangay()  + ", " +
                                perEmployee.getAddress().getCity()  + " City, " +
                                perEmployee.getAddress().getZip()  + "\n\t" +
                                "Other Info:\n" ); 
                             
            System.out.print( "\t\t" + 
                                "Birthday: " +
                                perEmployee.getOther().getBirthday() + "\n\t\t");
            System.out.printf(  "GWA: %.2f", perEmployee.getOther().getGwa());
            System.out.print(   "\n\t\t" +
                                "Hire date: " +
                                perEmployee.getOther().getHireDate() + "\n\t\t" +
                                "Currently employed?: " +
                                perEmployee.getOther().getIsHired() + "\n\t" +
                                "Contact Info:" );

            Set<Contact> contactList = perEmployee.getContact();                   
            for(Contact perContact : contactList) {
                System.out.print(   "\n\t\t" + 
                                    "Landline: " +
                                    perContact.getLandline() + "\n\t\t" +
                                    "Mobile: " +
                                    perContact.getMobile() + "\n\t\t" +
                                    "E-mail: " +
                                    perContact.getEmail() + "\n");
            }
            System.out.print("\tRoles:");
            Set<Roles> rolesList = perEmployee.getRoles();
            for(Roles perRole : rolesList) {
                System.out.print("\n\t\t" + perRole.getRole());
            }
            System.out.println();
        }
    }
}
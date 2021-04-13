package xyz.merccurion;

import java.util.HashSet;

public class MEService {
    Util util = new Util();

    public Employee addEmployeeDetails() {
        // String lastName = util.getString("Last Name: ");
        // String firstName = util.getString("First Name: ");
        // String middleName = util.getString("Middle Name: ");
        // String suffix = util.getString("Suffix: ");
        // String title = util.getString("Title: ");
        // Name name = new Name(lastName,firstName,middleName,suffix,title);

        // int streetNo = util.getInt("Street No.: ");
        // String barangay = util.getString("Barangay: ");
        // String city = util.getString("City: ");
        // int zip = util.getInt("Zip: ");
        // Address address = new Address(streetNo,barangay,city,zip);

        // String birthday = util.getString("Birthday (MM/DD/YYYY): ");
        // double gwa = util.getDouble("GWA: ");
        // String hireDate = util.getString("Hire date (MM/DD/YYYY): ");
        // boolean isHired = util.getBoolean("Currently employed? (Y/N): ");
        // OtherInfo other = new OtherInfo(birthday,gwa,hireDate,isHired);

        // int landline = util.getInt("Landline: ");
        // String mobile = util.getString("Mobile: ");
        // String email = util.getString("email: ");
        // Contact contact = new Contact(landline,mobile,email);

        // Employee employee = new Employee(name,address,other,contact);

        // return employee;

        String lastName = "Lacson";
        String firstName = "Jann Ily";
        String middleName = "Gabriel";
        String suffix = "";
        String title = "Engr.";
        Name name = new Name(lastName,firstName,middleName,suffix,title);

        int streetNo = 86;
        String barangay = "Tonsuya";
        String city = "Malabon";
        int zip = 1473;
        Address address = new Address(streetNo,barangay,city,zip);

        String birthday = "01/08/1998";
        double gwa = 2.15;
        String hireDate = "04/12/2021";
        boolean isHired = true;
        OtherInfo other = new OtherInfo(birthday,gwa,hireDate,isHired);

        int landline = 3751495;
        String mobile = "09152435453";
        String email = "jlacson@exist.com";
        Contact contact = new Contact(landline,mobile,email);

        Employee employee = new Employee(name,address,other,contact);

        return employee;
    }

    public HashSet<Roles> addEmployeeRoles() {
        System.out.println("Add roles (type e to finish adding roles)");
        HashSet<Roles> roles = new HashSet<Roles>();
        String role;
        do {
            role = util.getString("Add role: ");
            roles.add(new Roles(role));
        } while(!role.equalsIgnoreCase("e"));
        return roles;
    }
}
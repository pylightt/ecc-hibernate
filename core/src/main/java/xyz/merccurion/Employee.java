package xyz.merccurion;

import java.util.LinkedHashSet;
import java.util.Set;


public class Employee {
    private int id;

    private Name name;
    private Address address;
    private Other other;
    private Contact contact;
    private Set<Roles> roles = new LinkedHashSet<Roles>();

    public Employee() {};

    public Employee(Name name, Address address, Other other, Contact contact) {
        this.name = name;
        this.address = address;
        this.other = other;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { 
        this.id = id;
    }
   
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Other getOther() {
        return other;
    }
    public void setOther(Other other){
        this.other = other;
    }

    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Roles> getRoles() {
        return roles;
    }
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
    

}
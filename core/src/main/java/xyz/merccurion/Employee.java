package xyz.merccurion;

import java.util.Set;


public class Employee {
    private int id;

    private Name name;
    private Address address;
    private OtherInfo other;
    private Contact contact;
    private Set<Roles> roles;

    public Employee() {};

    public Employee(Name name, Address address, OtherInfo other, Contact contact) {
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

    public OtherInfo getOtherInfo() {
        return other;
    }
    public void setOtherInfo(OtherInfo other){
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
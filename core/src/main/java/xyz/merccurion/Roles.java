package xyz.merccurion;

import java.util.LinkedHashSet;
import java.util.Set;

public class Roles {   
    private int roleid;
    private String role;
    private Set<Employee> employee = new LinkedHashSet<Employee>();

    public Roles() {}
    
    public Roles(String role) {
        this.role = role;
    }

    public int getRoleid() {
        return roleid;
    }
    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }
    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
    

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Roles obj2 = (Roles)obj;
        if ((this.roleid == obj2.getRoleid()) && (this.role.equals(obj2.getRole()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int tmp = 0;
        tmp = (roleid + role).hashCode();
        return tmp;
    }
}
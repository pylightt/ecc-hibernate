package xyz.merccurion;

public class Roles {
    
    private int id;
    private String role;

    public Roles() {}
    
    public Roles(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Roles obj2 = (Roles)obj;
        if ((this.id == obj2.getId()) && (this.role.equals(obj2.getRole()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int tmp = 0;
        tmp = (id + role).hashCode();
        return tmp;
    }

}
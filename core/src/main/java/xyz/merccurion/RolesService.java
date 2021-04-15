package xyz.merccurion;

public class RolesService {

    Util util = new Util();

    public Roles addRoleDetails() {
        Roles roles = new Roles(util.getString("(Enter 'e' to finish adding roles)\nAdd role: "));        
        return roles;
    }
    
    public void addRole(Roles role) {
        RolesDao rDao = new RolesDao();
        rDao.addRole(role);
    }
    
    public void deleteRole(int id) {
        RolesDao rDao = new RolesDao();
        Roles role = rDao.getRole(id);
        rDao.deleteRole(role);
    }

    public Roles getRole(int id) {
        RolesDao rDao = new RolesDao();
        Roles role = rDao.getRole(id);
        return role;
    }
    
}

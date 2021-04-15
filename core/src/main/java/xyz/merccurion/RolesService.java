package xyz.merccurion;

import java.util.List;

public class RolesService {

    Util util = new Util();

    public Roles addRoleDetails() {
        Roles roles = new Roles(util.getString("\n(Enter 'e' to finish adding roles)\nAdd role: "));        
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

    public List<Roles> listRoles() {
        RolesDao rDao = new RolesDao();
        List<Roles> roles = rDao.listRoles();
        return roles;
    }
    
    public void updateRole(Roles role) {
        String update = util.getString("\nUpdated role: ");
        role.setRole(update);
        RolesDao rDao = new RolesDao();
        rDao.updateRole(role);
    }
}

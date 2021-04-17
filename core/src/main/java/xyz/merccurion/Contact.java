package xyz.merccurion;

public class Contact {
    private int contactid;
    private String landline;
    private String mobile;
    private String email;
    private Employee employee = new Employee();

    public Contact() {}

    public Contact(String landline, String mobile, String email){
        this.landline = landline;
        this.mobile = mobile;
        this.email = email;
    }

    public int getContactid() {
        return contactid;
    }
    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public String getLandline() {
        return landline;
    }
    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
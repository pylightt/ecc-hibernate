package xyz.merccurion;

public class Contact {

    private int landline;
    private String mobile;
    private String email;

    public Contact() {}
    public Contact(int landline, String mobile, String email){
        this.landline = landline;
        this.mobile = mobile;
        this.email = email;
    }

    public int getLandline() {
        return landline;
    }
    public void setLandline(int landline) {
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
}
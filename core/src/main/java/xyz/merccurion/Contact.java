package xyz.merccurion;

public class Contact {

    private String landline;
    private String mobile;
    private String email;

    public Contact() {}
    public Contact(String landline, String mobile, String email){
        this.landline = landline;
        this.mobile = mobile;
        this.email = email;
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
}
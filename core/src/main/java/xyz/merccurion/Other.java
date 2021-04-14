package xyz.merccurion;

public class Other {

    private String birthday;
    private double gwa;
    private String hireDate;
    private boolean isHired;

    public Other() {}
    
    public Other(String birthday, double gwa, String hireDate, boolean isHired) {
        this.birthday = birthday;
        this.gwa = gwa;
        this.hireDate = hireDate;
        this.isHired = isHired;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
       this.birthday = birthday;
    }

    public double getGwa() {
        return gwa;
    }
    public void setGwa(double gwa) {
        this.gwa = gwa;
    }

    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public boolean getIsHired() {
        return isHired;
    }
    public void setIsHired(boolean isHired) {
        this.isHired = isHired;
    }
}
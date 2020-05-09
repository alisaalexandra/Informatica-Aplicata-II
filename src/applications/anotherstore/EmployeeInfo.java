package applications.anotherstore;

public class EmployeeInfo {
    private String name;
    private String phoneNumber;
    private String adress;

    public EmployeeInfo(String name, String phoneNumber, String adress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
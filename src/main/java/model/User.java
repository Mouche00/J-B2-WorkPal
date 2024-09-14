package model;

public class User {

    protected String name;
    protected String email;
    protected String password;
    protected String address;
    protected String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User(String name, String email, String password, String address, String number) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.number = number;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

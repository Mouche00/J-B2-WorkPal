package model;

import utils.enums.Role;

public class LoggedInUser extends User {
    private String id;
    private Role role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LoggedInUser(String id, String name, String email, String password, String address, String number) {
        super(name, email, password, address, number);
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoggedInUser{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

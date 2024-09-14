package model;

import java.util.List;

public class Workspace {

    private String id;
    private String name;
    private String description;
    private double size;
    private double price;
    private String managerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Workspace(String id, String name, String description, double size, double price, String managerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.managerId = managerId;
    }

    public Workspace(String name, String description, double size, double price, String managerId) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.managerId = managerId;
    }

    public Workspace(String name, String description, double size, double price) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
    }

    public Workspace() {
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", managerId='" + managerId + '\'' +
                '}';
    }
}

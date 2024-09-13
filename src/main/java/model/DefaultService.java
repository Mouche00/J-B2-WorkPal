package model;

public class DefaultService extends Service {
    private String workspace;

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public DefaultService(String name, String description, double price, String workspace) {
        super(name, description, price);
        this.workspace = workspace;
    }
}

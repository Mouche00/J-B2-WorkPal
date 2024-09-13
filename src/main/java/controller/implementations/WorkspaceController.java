package controller.implementations;

import UI.inputs.AuthInputs;
import UI.inputs.WorkspaceInputs;
import controller.implementations.auth.LoginController;
import model.DefaultService;
import model.Workspace;
import repository.implementations.DefaultServiceRepository;
import service.implementations.DefaultServiceService;
import service.interfaces.WorkspaceServiceInterface;

import java.sql.SQLException;
import java.util.Map;

public class WorkspaceController {

    private final WorkspaceServiceInterface service;
    WorkspaceInputs inputs = new WorkspaceInputs();

    public WorkspaceController(WorkspaceServiceInterface service) {
        this.service = service;
    }

    public void create() {

        try {
            Workspace workspace = inputs.create();
            workspace.setManager(LoginController.getLoggedUser().get().getId());
            System.out.println(workspace);
            service.save(workspace);

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void getAll() {

        try {
            for(Map.Entry<String, Workspace> workspace : service.getAll().entrySet()){
                System.out.println(workspace.getKey() + ": " + workspace.getValue());
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

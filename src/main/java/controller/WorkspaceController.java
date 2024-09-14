package controller;

import UI.inputs.WorkspaceInputs;
import model.Workspace;
import service.interfaces.WorkspaceServiceInterface;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public class WorkspaceController {

    private final WorkspaceServiceInterface service;
    WorkspaceInputs inputs = new WorkspaceInputs();

    public WorkspaceController(WorkspaceServiceInterface service) {
        this.service = service;
    }

    public void create() {

        try {
            String name = Validator.validateInput("Enter the workspace' name: ", InputType.STRING);
            String description = Validator.validateInput("Enter the workspace' description: ", InputType.STRING);
            double size = Parser.parseDouble(
                    Validator.validateInput("Enter the workspace' size: ", InputType.DOUBLE)).get();
            double price = Parser.parseDouble(
                    Validator.validateInput("Enter the workspace' price: ", InputType.DOUBLE)).get();
            String managerId = Session.getLoggedUser().get().getId();

            service.save(new Workspace(name, description, size, price, managerId));

        } catch (SQLException | IllegalAccessException e) {
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

package UI.inputs;

import model.DefaultService;
import model.Workspace;
import utils.Parser;
import utils.Validator;
import utils.enums.InputType;

import java.util.ArrayList;
import java.util.List;

public class WorkspaceInputs {

    public Workspace create() {
        String name = Validator.validateInput("Enter the workspace' name: ", InputType.STRING);
        String description = Validator.validateInput("Enter the workspace' description: ", InputType.STRING);
        double size = Parser.parseDouble(
                Validator.validateInput("Enter the workspace' size: ", InputType.DOUBLE)).get();
        double price = Parser.parseDouble(
                Validator.validateInput("Enter the workspace' price: ", InputType.DOUBLE)).get();
        int numServices = Parser.parseInt(
                Validator.validateInput("Enter the workspace' number of services: ", InputType.INTEGER));

        return new Workspace(name, description, size, price);
    }
}

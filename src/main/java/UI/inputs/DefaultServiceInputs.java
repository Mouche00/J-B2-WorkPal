package UI.inputs;

import model.DefaultService;
import model.Workspace;
import utils.Parser;
import utils.Validator;
import utils.enums.InputType;

import java.util.ArrayList;
import java.util.List;

public class DefaultServiceInputs {

    public DefaultService create() {

        String name = Validator.validateInput("Enter the service' name: ", InputType.STRING);
        String description = Validator.validateInput("Enter the service' description: ", InputType.STRING);
        double price = Parser.parseDouble(
                Validator.validateInput("Enter the service' price: ", InputType.DOUBLE)).get();

        String workspaceId = Validator.validateInput("Enter the service' workspace id: ", InputType.STRING);

        return new DefaultService(name, description, price, workspaceId);
    }
}

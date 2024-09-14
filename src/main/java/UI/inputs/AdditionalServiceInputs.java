package UI.inputs;

import model.AdditionalService;
import model.DefaultService;
import utils.Parser;
import utils.Validator;
import utils.enums.InputType;

public class AdditionalServiceInputs {

    public AdditionalService create() {

        String name = Validator.validateInput("Enter the service' name: ", InputType.STRING);
        String description = Validator.validateInput("Enter the service' description: ", InputType.STRING);
        double price = Parser.parseDouble(
                Validator.validateInput("Enter the service' price: ", InputType.DOUBLE)).get();

        return new AdditionalService(name, description, price);
    }
}

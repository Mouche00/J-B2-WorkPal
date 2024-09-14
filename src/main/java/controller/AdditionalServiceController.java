package controller;

import model.AdditionalService;
import service.interfaces.ServiceInterface;
import utils.Parser;
import utils.Validator;
import utils.enums.InputType;

import java.sql.SQLException;

public class AdditionalServiceController extends Controller<AdditionalService> {

    public AdditionalServiceController(ServiceInterface<AdditionalService> service) {
        super(service);
    }

    public void create() {

        try {
            String name = Validator.validateInput("Enter the service' name: ", InputType.STRING);
            String description = Validator.validateInput("Enter the service' description: ", InputType.STRING);
            double price = Parser.parseDouble(
                    Validator.validateInput("Enter the service' price: ", InputType.DOUBLE)).get();

            service.save(new AdditionalService(name, description, price));

        } catch (SQLException | IllegalAccessException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

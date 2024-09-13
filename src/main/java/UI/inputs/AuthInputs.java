package UI.inputs;

import DTO.UserDTO;
import utils.Validator;
import utils.enums.InputType;

public class AuthInputs {

    public UserDTO register() {

        String name = Validator.validateInput("Enter your name: ", InputType.STRING);
        String email = Validator.validateInput("Enter your email: ", InputType.EMAIL);
        String password = Validator.validateInput("Enter your password: ", InputType.PASSWORD);
        String address = Validator.validateInput("Enter your address: ", InputType.STRING);
        String number = Validator.validateInput("Enter your number: ", InputType.INTEGER);

        return new UserDTO(name, email, password, address, number);
    }

    public UserDTO login() {

        String email = Validator.validateInput("Enter your email: ", InputType.STRING);
        String password = Validator.validateInput("Enter your password: ", InputType.PASSWORD);

        return new UserDTO(email, password);
    }
}

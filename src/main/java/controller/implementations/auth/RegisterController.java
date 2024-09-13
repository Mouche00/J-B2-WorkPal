package controller.implementations.auth;

import DTO.UserDTO;
import UI.inputs.AuthInputs;
import controller.interfaces.auth.RegisterControllerInterface;
import service.implementations.auth.RegisterService;

import java.sql.SQLException;
import java.util.Optional;

public class RegisterController implements RegisterControllerInterface {
    private final RegisterService service;
    AuthInputs inputs = new AuthInputs();

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @Override
    public void showRegister() {
         this.register(inputs.register());
    }

    @Override
    public Optional<UserDTO> register(UserDTO userDTO) {

        try {
            service.save(userDTO);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return Optional.empty();
    }
}

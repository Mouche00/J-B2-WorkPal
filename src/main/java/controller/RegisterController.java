package controller;

import DTO.UserDTO;
import UI.inputs.AuthInputs;
import service.implementations.auth.RegisterService;

import java.sql.SQLException;
import java.util.Optional;

public class RegisterController {
    private final RegisterService service;
    AuthInputs inputs = new AuthInputs();

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    public void showRegister() {
         this.register(inputs.register());
    }

    public Optional<UserDTO> register(UserDTO userDTO) {

        try {
            service.save(userDTO);
        } catch (SQLException | IllegalAccessException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return Optional.empty();
    }
}

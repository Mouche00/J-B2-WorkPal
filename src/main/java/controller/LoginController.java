package controller;

import DTO.UserDTO;
import UI.inputs.AuthInputs;
import service.interfaces.auth.LoginServiceInterface;

import java.sql.SQLException;
import java.util.Optional;

public class LoginController {
    private final LoginServiceInterface service;
    private static Optional<UserDTO> loggedUser = Optional.empty();
    AuthInputs inputs = new AuthInputs();

    public LoginController(LoginServiceInterface service) {
        this.service = service;
    }

    public void showLogin() {
         this.login(inputs.login());
    }

    public void login(UserDTO userDTO) {

        try {
            loggedUser = service.login(userDTO);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static Optional<UserDTO> getLoggedUser() {
        return loggedUser;
    }

    public void resetPassword() {

    }
}

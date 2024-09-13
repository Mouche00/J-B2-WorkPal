package controller.implementations.auth;

import DTO.UserDTO;
import UI.inputs.AuthInputs;
import controller.interfaces.auth.LoginControllerInterface;
import service.interfaces.auth.LoginServiceInterface;

import java.sql.SQLException;
import java.util.Optional;

public class LoginController implements LoginControllerInterface {
    private final LoginServiceInterface service;
    private static Optional<UserDTO> loggedUser = Optional.empty();
    AuthInputs inputs = new AuthInputs();

    public LoginController(LoginServiceInterface service) {
        this.service = service;
    }

    @Override
    public void showLogin() {
         this.login(inputs.login());
    }

    @Override
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
}

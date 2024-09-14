package utils;

import DTO.UserDTO;
import UI.inputs.AuthInputs;
import model.LoggedInUser;
import model.User;
import service.interfaces.auth.LoginServiceInterface;

import java.sql.SQLException;
import java.util.Optional;

public class Session {

    private static Optional<LoggedInUser> loggedUser = Optional.empty();

    public static Optional<LoggedInUser> getLoggedUser() {
        return loggedUser;
    }
    public static void setLoggedUser(Optional<LoggedInUser> user) {
        loggedUser = user;
    }
}

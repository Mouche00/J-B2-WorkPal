package controller.interfaces.auth;

import DTO.UserDTO;

public interface LoginControllerInterface {

    void showLogin();
    void login(UserDTO userDTO);
}

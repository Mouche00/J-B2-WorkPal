package controller.interfaces.auth;

import DTO.UserDTO;
import java.util.Optional;

public interface RegisterControllerInterface {

    void showRegister();
    Optional<UserDTO> register(UserDTO userDTO);
}

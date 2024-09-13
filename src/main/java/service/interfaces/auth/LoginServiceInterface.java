package service.interfaces.auth;

import DTO.UserDTO;

import java.sql.SQLException;
import java.util.Optional;

public interface LoginServiceInterface {

    Optional<UserDTO> login(UserDTO userDTO) throws SQLException;
}

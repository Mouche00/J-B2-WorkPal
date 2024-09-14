package service.interfaces.auth;

import DTO.UserDTO;
import model.User;
import service.interfaces.ServiceInterface;

import java.sql.SQLException;

public interface RegisterServiceInterface  {
    void save(UserDTO user) throws SQLException, IllegalAccessException;
}

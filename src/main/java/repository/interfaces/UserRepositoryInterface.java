package repository.interfaces;

import DTO.UserDTO;
import utils.enums.Role;

import java.sql.SQLException;
import java.util.Optional;

public interface UserRepositoryInterface {
    Optional<UserDTO> findByEmail(String email) throws SQLException;
    Role getRole(String id) throws SQLException;
    boolean isMember(String id) throws SQLException;
    boolean isManager(String id) throws SQLException;
    boolean isAdmin(String id) throws SQLException;


}

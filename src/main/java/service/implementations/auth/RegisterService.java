package service.implementations.auth;

import DTO.UserDTO;
import repository.interfaces.RepositoryInterface;
import service.interfaces.auth.RegisterServiceInterface;

import java.sql.SQLException;

public class RegisterService implements RegisterServiceInterface {
    private final RepositoryInterface<UserDTO> repository;

    public RegisterService(RepositoryInterface<UserDTO> repository) {
        this.repository = repository;
    }

    @Override
    public void save(UserDTO userDTO) throws SQLException, IllegalAccessException {

        repository.save(userDTO);
    }
}

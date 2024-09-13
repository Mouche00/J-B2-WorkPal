package service.implementations.auth;

import DTO.UserDTO;
import repository.interfaces.RepositoryInterface;
import repository.interfaces.UserRepositoryInterface;
import service.interfaces.auth.LoginServiceInterface;

import java.sql.SQLException;
import java.util.Optional;

public class LoginService implements LoginServiceInterface {
    private final UserRepositoryInterface repository;

    public LoginService(UserRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserDTO> login(UserDTO userDTO) throws SQLException {
        Optional<UserDTO> user = repository.findByEmail(userDTO.getEmail());
        if(user.isPresent() && user.get().getPassword().equals(userDTO.getPassword())) {
            user.get().setRole(repository.getRole(user.get().getId()));
            return user;
        }

        return Optional.empty();
    }
}

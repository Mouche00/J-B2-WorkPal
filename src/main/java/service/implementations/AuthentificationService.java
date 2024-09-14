package service.implementations;

import DTO.UserDTO;
import model.LoggedInUser;
import model.User;
import repository.implementations.AdditionalServiceRepository;
import repository.implementations.UserRepository;
import repository.interfaces.RepositoryInterface;
import repository.interfaces.UserRepositoryInterface;
import service.interfaces.ServiceInterface;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class AuthentificationService<T extends User> implements ServiceInterface<T> {
    private final UserRepository<T> repository;
    public AuthentificationService(UserRepository<T> repository) {
        this.repository = repository;
    }

    public Optional<LoggedInUser> login(User user) throws SQLException {
        Optional<LoggedInUser> userToFind = repository.findByEmail(user.getEmail());
        if(userToFind.isPresent() && userToFind.get().getPassword().equals(user.getPassword())) {
            userToFind.get().setRole(repository.getRole(userToFind.get().getId()));
            return userToFind;
        }

        return Optional.empty();
    }

    @Override
    public void save(T t) throws SQLException, IllegalAccessException {
        repository.save(t);
    }

    @Override
    public HashMap<String, T> getAll() throws SQLException {
        return null;
    }
}

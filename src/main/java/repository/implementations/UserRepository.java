package repository.implementations;

import model.User;
import repository.interfaces.UserRepositoryInterface;

import java.util.Optional;

public class UserRepository implements UserRepositoryInterface {
    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public boolean verifyPassword(String password) {
        return false;
    }
}

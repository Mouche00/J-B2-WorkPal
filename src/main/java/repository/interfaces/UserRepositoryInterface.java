package repository.interfaces;

import model.User;

import java.util.Optional;

public interface UserRepositoryInterface  {
    Optional<User> findByEmail(String email);
    boolean verifyPassword(String password);


}

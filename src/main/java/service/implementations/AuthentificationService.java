package service.implementations;

import service.interfaces.AuthentificationServiceInterface;

import java.util.Optional;

public class AuthentificationService implements AuthentificationServiceInterface {

    @Override
    public Optional<?> authenticate(String email, String password) {
        return Optional.empty();
    }

    @Override
    public Optional<?> register() {
        return Optional.empty();
    }
}

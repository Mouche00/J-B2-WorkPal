package service.interfaces;

import java.util.Optional;

public interface AuthentificationServiceInterface {

    Optional<?> authenticate(String email, String password);
    Optional<?> register();
}

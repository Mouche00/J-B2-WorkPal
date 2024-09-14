package controller;

import DTO.UserDTO;
import model.Member;
import model.User;
import service.implementations.AuthentificationService;
import service.interfaces.ServiceInterface;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class AuthentificationController<T extends User> {
    private Class<T> clazz;
    private AuthentificationService<T> service;
    public AuthentificationController(AuthentificationService<T> service, Class<T> clazz) {
        this.service = service;
        this.clazz = clazz;
    }

    public AuthentificationController(AuthentificationService<T> service) {
        this.service = service;
    }

    public void login() {
        String email = Validator.validateInput("Enter your email: ", InputType.STRING);
        String password = Validator.validateInput("Enter your password: ", InputType.PASSWORD);
        User user = new User(email, password);
        try {
            Session.setLoggedUser(service.login(user));
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void register() {
        try {
            T user = clazz.getDeclaredConstructor().newInstance();
            user.setName(Validator.validateInput("Enter your name: ", InputType.STRING));
            user.setEmail(Validator.validateInput("Enter your email: ", InputType.EMAIL));
            user.setPassword(Validator.validateInput("Enter your password: ", InputType.PASSWORD));
            user.setAddress(Validator.validateInput("Enter your address: ", InputType.STRING));
            user.setNumber(Validator.validateInput("Enter your number: ", InputType.INTEGER));

            service.save(user);
        } catch (SQLException | IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

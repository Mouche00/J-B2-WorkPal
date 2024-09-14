package controller;

import repository.interfaces.UserRepositoryInterface;
import service.interfaces.ServiceInterface;

public class Controller<T> {
    protected ServiceInterface<T> service;
    public Controller(ServiceInterface<T> service) {
        this.service = service;
    }
}

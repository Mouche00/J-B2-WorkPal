package service.implementations;

import repository.interfaces.RepositoryInterface;
import service.interfaces.ServiceInterface;

public class Service<T> {

    protected RepositoryInterface<T> repository;
    public Service(RepositoryInterface<T> repository) {
        this.repository = repository;
    }
}

package service.implementations;

import model.DefaultService;
import repository.implementations.DefaultServiceRepository;
import repository.implementations.WorkspaceRepository;
import service.interfaces.ServiceInterface;

import java.sql.SQLException;
import java.util.HashMap;

public class DefaultServiceService implements ServiceInterface<DefaultService> {

    private final DefaultServiceRepository repository;
    public DefaultServiceService(DefaultServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(DefaultService defaultService) throws SQLException {
        repository.save(defaultService);
    }

    @Override
    public HashMap<String, DefaultService> getAll() throws SQLException {
        return null;
    }
}

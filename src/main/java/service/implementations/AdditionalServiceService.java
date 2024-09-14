package service.implementations;

import model.AdditionalService;
import repository.implementations.AdditionalServiceRepository;
import repository.implementations.DefaultServiceRepository;
import service.interfaces.ServiceInterface;

import java.sql.SQLException;
import java.util.HashMap;

public class AdditionalServiceService implements ServiceInterface<AdditionalService> {
    private final AdditionalServiceRepository repository;
    public AdditionalServiceService(AdditionalServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(AdditionalService additionalService) throws SQLException, IllegalAccessException {
        repository.save(additionalService);
    }

    @Override
    public HashMap<String, AdditionalService> getAll() throws SQLException {
        return null;
    }
}

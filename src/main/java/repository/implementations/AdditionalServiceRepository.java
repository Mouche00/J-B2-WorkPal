package repository.implementations;

import model.AdditionalService;
import repository.interfaces.RepositoryInterface;
import utils.database.ORM;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class AdditionalServiceRepository extends Repository implements RepositoryInterface<AdditionalService> {

    @Override
    public Optional<AdditionalService> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public HashMap<String, AdditionalService> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(AdditionalService additionalService) throws SQLException, IllegalAccessException {
        ORM.save(additionalService);
    }

    @Override
    public boolean update(AdditionalService additionalService) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(AdditionalService additionalService) throws SQLException {
        return false;
    }
}

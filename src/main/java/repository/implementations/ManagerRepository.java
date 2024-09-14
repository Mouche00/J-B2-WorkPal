package repository.implementations;

import DTO.UserDTO;
import model.Manager;
import repository.interfaces.RepositoryInterface;
import utils.database.ORM;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class ManagerRepository extends Repository implements RepositoryInterface<Manager> {

    @Override
    public Optional<Manager> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public HashMap<String, Manager> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Manager manager) throws SQLException, IllegalAccessException {
        ORM.save(manager);
    }

    @Override
    public boolean update(Manager manager) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Manager manager) throws SQLException {
        return false;
    }
}

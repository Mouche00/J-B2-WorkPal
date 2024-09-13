package repository.implementations;

import model.DefaultService;
import repository.interfaces.DefaultServiceRepositoryInterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class DefaultServiceRepository extends Repository implements DefaultServiceRepositoryInterface {
    @Override
    public Optional<DefaultService> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public HashMap<String, DefaultService> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(DefaultService defaultService) throws SQLException {
        String sql = "INSERT INTO default_services (name, description, price, workspace_id) VALUES (?, ?, ?, ?::uuid)";

        PreparedStatement statement = connection.get().prepareStatement(sql);

        statement.setString(1, defaultService.getName());
        statement.setString(2, defaultService.getDescription());
        statement.setDouble(3, defaultService.getPrice());
        statement.setString(4, defaultService.getWorkspace());

//        statement.setObject(5, Parser.parseUUID(workspace.getManagerId()), Types.OTHER);

        return statement.execute();
    }

    @Override
    public boolean update(DefaultService defaultService) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(DefaultService defaultService) throws SQLException {
        return false;
    }
}

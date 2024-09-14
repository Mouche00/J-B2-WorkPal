package repository.implementations;

import model.Workspace;
import repository.interfaces.RepositoryInterface;
import repository.interfaces.WorkspaceRepositoryInterface;
import utils.database.ORM;

import java.sql.*;
import java.util.*;

public class WorkspaceRepository extends Repository implements RepositoryInterface<Workspace> {
    @Override
    public Optional<Workspace> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public HashMap<String, Workspace> getAll() throws SQLException {
        HashMap<String, Workspace> workspaces = new HashMap<>();
//        String sql = "SELECT w.*, m.name as manager_name FROM workspaces w JOIN managers m ON w.manager_id = m.id";
//        String sql = "SELECT w.*, d.* FROM workspaces";
//        Statement statement = connection.get().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        while (resultSet.next()) {
////            String managerName = resultSet.getString("manager_name");
//            String manager = resultSet.getString("manager_id");
//            String name = resultSet.getString("name");
//            String workspaceId = resultSet.getString("id");
//            String description = resultSet.getString("description");
//            double size = resultSet.getDouble("size");
//            double price = resultSet.getDouble("price");
//            Workspace workspace = new Workspace(name, description, size, price, manager);
//            workspaces.put(workspaceId, workspace);
//        }
        return workspaces;
    }

    @Override
    public void save(Workspace workspace) throws SQLException, IllegalAccessException {
        ORM.save(workspace);
    }

    @Override
    public boolean update(Workspace workspace) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Workspace workspace) throws SQLException {
        return false;
    }
}

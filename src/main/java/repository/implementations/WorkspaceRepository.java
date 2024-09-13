package repository.implementations;

import model.Workspace;
import repository.interfaces.WorkspaceRepositoryInterface;
import utils.Parser;

import java.sql.*;
import java.util.*;

public class WorkspaceRepository extends Repository implements WorkspaceRepositoryInterface {
    @Override
    public Optional<Workspace> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public HashMap<String, Workspace> getAll() throws SQLException {
        HashMap<String, Workspace> workspaces = new HashMap<>();
//        String sql = "SELECT w.*, m.name as manager_name FROM workspaces w JOIN managers m ON w.manager_id = m.id";
        String sql = "SELECT w.*, d.* FROM workspaces";
        Statement statement = connection.get().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
//            String managerName = resultSet.getString("manager_name");
            String manager = resultSet.getString("manager_id");
            String name = resultSet.getString("name");
            String workspaceId = resultSet.getString("id");
            String description = resultSet.getString("description");
            double size = resultSet.getDouble("size");
            double price = resultSet.getDouble("price");
            Workspace workspace = new Workspace(name, description, size, price, manager);
            workspaces.put(workspaceId, workspace);
        }
        return workspaces;
    }

    @Override
    public boolean save(Workspace workspace) throws SQLException {
        String sql = "INSERT INTO workspaces (name, description, size, price, manager_id) VALUES (?, ?, ?, ?, ?::uuid)";

        PreparedStatement statement = connection.get().prepareStatement(sql);

        statement.setString(1, workspace.getName());
        statement.setString(2, workspace.getDescription());
        statement.setDouble(3, workspace.getSize());
        statement.setDouble(4, workspace.getPrice());
        statement.setString(5, workspace.getManager());

//        statement.setObject(5, Parser.parseUUID(workspace.getManagerId()), Types.OTHER);

        return statement.execute();
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

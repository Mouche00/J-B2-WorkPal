package repository.implementations;

import model.LoggedInUser;
import model.User;
import repository.interfaces.RepositoryInterface;
import repository.interfaces.UserRepositoryInterface;
import utils.database.ORM;
import utils.enums.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class UserRepository<T extends User> extends Repository implements UserRepositoryInterface, RepositoryInterface<T> {
    @Override
    public Optional<LoggedInUser> findByEmail(String email) throws SQLException {
        Optional<LoggedInUser> user = Optional.empty();
        String sql = "SELECT * FROM users WHERE email = ?";
        PreparedStatement statement = connection.get().prepareStatement(sql);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String address = resultSet.getString("address");
            String number = resultSet.getString("number");

            user = Optional.of(new LoggedInUser(id, name, email, password, address, number));
        }

        return user;
    }

//    @Override
//    public String getRole(String id) throws SQLException {
//        UUID uuid = UUID.fromString(id);
//        String sql = "SELECT tableoid::regclass FROM users WHERE id = " + "'" + uuid + "'";
//        Statement statement = connection.get().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        if(resultSet.next()) {
//            return resultSet.getString("tableoid");
//        }
//        return id;
//    }

    @Override
    public Role getRole(String id) throws SQLException {
        if(isMember(id)){
            return Role.MEMBER;
        } else if(isManager(id)){
            return Role.MANAGER;
        } else if (isAdmin(id)) {
            return Role.ADMIN;
        } else {
            return null;
        }
    }

    public boolean isMember(String id) throws SQLException {
        UUID uuid = UUID.fromString(id);
        String sql = "SELECT * FROM members WHERE id = " + "'" + uuid + "'";
        Statement statement = connection.get().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.next();
    }

    public boolean isManager(String id) throws SQLException {
        UUID uuid = UUID.fromString(id);
        String sql = "SELECT * FROM managers WHERE id = " + "'" + uuid + "'";
        Statement statement = connection.get().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.next();
    }

    public boolean isAdmin(String id) throws SQLException {
        UUID uuid = UUID.fromString(id);
        String sql = "SELECT * FROM admins WHERE id = " + "'" + uuid + "'";
        Statement statement = connection.get().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.next();
    }

    @Override
    public Optional<T> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public HashMap<String, T> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(T t) throws SQLException, IllegalAccessException {
        ORM.save(t);
    }

    @Override
    public boolean update(T t) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(T t) throws SQLException {
        return false;
    }
}

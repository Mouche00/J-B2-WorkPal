package repository.implementations;

import DTO.UserDTO;
import repository.interfaces.ManagerRepositoryInterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ManagerRepository extends Repository implements ManagerRepositoryInterface {
    @Override
    public Optional<UserDTO> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public HashMap<String, UserDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(UserDTO userDTO) throws SQLException {
        String sql = "INSERT INTO managers (name, email, password, address, number) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.get().prepareStatement(sql);

        statement.setString(1, userDTO.getName());
        statement.setString(2, userDTO.getEmail());
        statement.setString(3, userDTO.getPassword());
        statement.setString(4, userDTO.getAddress());
        statement.setString(5, userDTO.getNumber());

        return statement.execute();
    }

    @Override
    public boolean update(UserDTO userDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(UserDTO userDTO) throws SQLException {
        return false;
    }
}

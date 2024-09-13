package repository.implementations;

import DTO.UserDTO;
import model.Member;
import repository.interfaces.MemberRepositoryInterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class MemberRepository extends Repository implements MemberRepositoryInterface {

    @Override
    public Optional<UserDTO> get(int id) {
        return Optional.empty();
    }

    @Override
    public HashMap<String, UserDTO> getAll() {
        return null;
    }

    @Override
    public boolean save(UserDTO userDTO) throws SQLException {
//        String message = "ERROR: the member cannot be null";
//        member = Objects.requireNonNull(member, message);
        String sql = "INSERT INTO members (name, email, password, address, number) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.get().prepareStatement(sql);

        statement.setString(1, userDTO.getName());
        statement.setString(2, userDTO.getEmail());
        statement.setString(3, userDTO.getPassword());
        statement.setString(4, userDTO.getAddress());
        statement.setString(5, userDTO.getNumber());

        return statement.execute();
    }

    @Override
    public boolean update(UserDTO userDTO) {
        return true;
    }

    @Override
    public boolean delete(UserDTO userDTO) {
        return true;
    }
}

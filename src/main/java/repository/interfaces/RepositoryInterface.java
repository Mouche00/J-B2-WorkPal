package repository.interfaces;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public interface RepositoryInterface<T> {
    Optional<T> get(int id) throws SQLException;
    HashMap<String, T> getAll() throws SQLException;
    void save(T t) throws SQLException, IllegalAccessException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
}
